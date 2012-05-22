/* $Id$
 *
 * OpenMAMA: The open middleware agnostic messaging API
 * Copyright (C) 2012 NYSE Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA
 */

package com.wombat.mamda.orderbook;

public class MamdaOrderBookInvalidEntryException extends MamdaOrderBookException
{
    private MamdaOrderBookEntry        mInvalidEntry;
    private MamdaBookAtomicLevelEntry  mInvalidLevelEntry;

    public MamdaOrderBookInvalidEntryException (
        MamdaOrderBookEntry entry, String s)
    {
        super (s);
        mInvalidEntry = entry;
    }

    public MamdaOrderBookEntry getInvalidEntry ()
    {
        return mInvalidEntry;
    }
    
    public MamdaOrderBookInvalidEntryException (
        MamdaBookAtomicLevelEntry levelEntry, String s)
    {
        super (s);
        mInvalidLevelEntry = levelEntry;
    }
    
    public MamdaBookAtomicLevelEntry getInvalidLevelEntry ()
    {
        return mInvalidLevelEntry;
    }
}