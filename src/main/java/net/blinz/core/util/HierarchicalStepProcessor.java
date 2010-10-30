/*
 * Dog - A project for making highly scalable non-clustered game and simulation environments.
 * Copyright (C) 2009-2010 BlinzProject <gtalent2@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.blinz.core.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Blinz
 */
public final class HierarchicalStepProcessor<E> {

    /**
     * Used to track the initialization steps for different classes.
     */
    private final HashMap<Class, ArrayList<Step<? extends E>>> initTable = new HashMap<Class, ArrayList<Step<? extends E>>>();
    private final HashMap<Class, SteppingProfile<? extends E>> initProfiles = new HashMap<Class, SteppingProfile<? extends E>>();
    private final ArrayList<TopLevelMethod<? extends E>> topLevelMethods = new ArrayList<TopLevelMethod<? extends E>>();

    /**
     * Adds a TopLevelMethod to this HierarchicalStepProcessor to be factored into
     * all execution profiles.
     *
     * Use of this Step results in the method being called as if it were called from
     * the reference directly, but it is called with the Steps of the last class to
     * implement it.
     *
     * @param clss the class to add the Step for
     * @param step the Step to add
     */
    public final void addTopLevelMethod(final TopLevelMethod<? extends E> step) {
        topLevelMethods.add(step);
    }

    /**
     * Adds the given Step for the given class.
     * @param clss the class to add the Step for
     * @param step the Step to add
     */
    public final void addStep(final Class clss, final Step<? extends E> step) {
        ArrayList<Step<? extends E>> steps = initTable.get(clss);
        if (steps == null) {
            steps = new ArrayList<Step<? extends E>>();
            synchronized (initTable) {
                if (!initTable.containsKey(clss)) {
                    initTable.put(clss, steps);
                } else {
                    steps = initTable.get(clss);
                }
            }
        }
        synchronized (steps) {
            steps.add(step);
        }
    }

    /**
     * Adds the given SteppingProfile to this HierarchicalStepProcessor.
     * @param clss the Class to associate with the given Profile
     * @param profile the SteppingProfile to add
     */
    public final void addProfile(final Class clss, final SteppingProfile<? extends E> profile) {
        synchronized (initProfiles) {
            if (!initProfiles.containsKey(clss)) {
                initProfiles.put(clss, profile);
            }
        }
    }

    /**
     * Gets a list of the steps for the given Class.
     * @param clss the Class of the steps you want
     * @return the steps for the given Class
     */
    public final ArrayList<Step<? extends E>> getSteps(final Class clss) {
        return initTable.get(clss);
    }

    /**
     * Gets a SteppingProfile associated with the given Class.
     * @param clss the Class for which you need a Stepping profile
     * @return a SteppingProfile associated with the given Class if there is one, null otherwise
     */
    public final SteppingProfile<? extends E> getProfile(final Class clss) {
        SteppingProfile profile = initProfiles.get(clss);
        if (profile == null) {
            synchronized (initProfiles) {
                if (!initProfiles.containsKey(clss)) {
                    initProfiles.put(clss, profile);
                } else {
                    profile = initProfiles.get(clss);
                }
            }
        }
        return profile;
    }

    /**
     * Runs the Steps assigned for the given object.
     * @param object the object run Steps on
     */
    final void run(final E object) {
        final Class cl = object.getClass();
        SteppingProfile profile = getProfile(cl);
        if (profile == null) {
            generateProfile(profile = new SteppingProfile(), cl, (ArrayList<TopLevelMethod<? extends E>>) topLevelMethods.clone());
            addProfile(cl, profile);
        }
        generateProfile(profile = new SteppingProfile(), cl, (ArrayList<TopLevelMethod<? extends E>>) topLevelMethods.clone());

        profile.run(object);
    }

    /**
     * Generates a SteppingProfile for the given Class.
     * @param profile the profile to generate
     * @param level the level in the class hierarchy that this method is on
     * @param topLevels the TopLevelMethods that still haven't found their homes
     */
    private final void generateProfile(final SteppingProfile profile, final Class level, final ArrayList<TopLevelMethod<? extends E>> topLevels) {
        if (level == Object.class) {
            return;
        }
        ArrayList<TopLevelMethod<? extends E>> topLevelsToAdd = null;
        for (int i = 0; i < topLevelsToAdd.size(); i++) {
            try {
                final Method current = level.getDeclaredMethod(topLevels.get(i).getMethod().getName());
                if (current != null) {
                    if (topLevelsToAdd == null) {
                        topLevelsToAdd = new ArrayList<TopLevelMethod<? extends E>>();
                    }
                    topLevelsToAdd.add(topLevelsToAdd.remove(i));
                }
            } catch (NoSuchMethodException ex) {
            } catch (SecurityException ex) {
                Logger.getLogger(HierarchicalStepProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        generateProfile(profile, level.getSuperclass(), topLevels);

        final ArrayList<Step<? extends E>> steps = getSteps(level);
        if (steps != null) {
            for (int i = 0; i < steps.size(); i++) {
                profile.addStep(steps.get(i));
            }
        }
    }
}
