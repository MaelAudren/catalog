/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package org.ow2.proactive.catalog.service;

import static com.google.common.truth.Truth.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * @author ActiveEon Team
 * @since 08/08/2017
 */
@RunWith(MockitoJUnitRunner.class)
public class GroupsWithPrefixRetrieverTest {

    @InjectMocks
    @Spy
    private OwnerGroupStringHelper ownerGroupStringHelper;

    @Test(expected = NullPointerException.class)
    public void testThatNullThrowsNullPointerException() {
        ownerGroupStringHelper.getGroupsWithPrefixFromGroupList(null);
    }

    @Test
    public void testThatEmptyListReturnsEmptyList() {
        assertThat(ownerGroupStringHelper.getGroupsWithPrefixFromGroupList(Collections.emptyList())).isEmpty();
    }

    @Test
    public void testThatGroupPrefixIsAdded() {
        List<String> result = ownerGroupStringHelper.getGroupsWithPrefixFromGroupList(Collections.singletonList("test"));
        assertThat(result).contains(OwnerGroupStringHelper.GROUP_PREFIX + "test");
    }

}
