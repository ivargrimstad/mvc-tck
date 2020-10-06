/*
 * Copyright © 2019 Christian Kaltepoth
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package org.mvcspec.tck.tests.security.csrf.header;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationPath("mvc")
public class CsrfCustomHeaderApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new LinkedHashMap<>();
        // TODO: Replace with actual constant from Csrf after updating the spec version
        properties.put("jakarta.mvc.security.CsrfHeaderName", "X-CSRF-Custom-Header-Name");
        return properties;
    }

}