/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.robonect.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An enumeration for the possible mower status. 
 *
 * @author Marco Meyer - Initial contribution
 */
public enum MowerStatus {

    /**
     * Status is being detected.
     */
    DETECTING_STATUS(0),
    /**
     * Mower is in charging station.
     */
    PARKING(1),

    /**
     * Mower is mowing.
     */
    MOWING(2),

    /**
     * Mower searches charging station
     */
    SEARCH_CHARGING_STATION(3),

    /**
     * Mower is charging.
     */
    CHARGING(4),

    /**
     * Mower is searching the remote start point.
     */
    SEARCHING(5),

    /**
     * Mower is in error state.
     */
    ERROR_STATUS(7),

    /**
     * Mower lost WLAN signal.
     */
    LOST_SIGNAL(8),

    /**
     * Mower is OFF.
     */
    OFF(16),

    /**
     * Mower is sleeping
     */
    SLEEPING(17),

    /**
     * unknown status. If the module return any not listed code here it will result in this state in the binding.
     */
    UNKNOWN(99);

    private static final Logger logger = LoggerFactory.getLogger(MowerStatus.class);

    private int statusCode;

    MowerStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * translates a numeric code into an enum value. If code is not known the value {@link #UNKNOWN} is returned.
     * @param code - the code to translate
     * @return - the correpsonding enum value.
     */
    public static MowerStatus fromCode(int code) {
        for (MowerStatus status : MowerStatus.values()) {
            if (status.statusCode == code) {
                return status;
            }
        }
        logger.debug("Got an unknown state with code {}", code);
        return UNKNOWN;
    }

    /**
     * returns the numeric code of the status.
     * @return
     */
    public int getStatusCode() {
        return statusCode;
    }

}
