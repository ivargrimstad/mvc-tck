/*
 * Copyright © 2017 Christian Kaltepoth
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
package ee.jakarta.tck.mvc.common;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import jakarta.mvc.security.Csrf;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("mvc")
public class DefaultApplication extends Application {

    // defaults
    @Override
    public Map<String, Object> getProperties() {
        final Map<String,Object> map = new HashMap<>();

        map.put(Csrf.CSRF_PROTECTION, Csrf.CsrfOptions.EXPLICIT);

        return map;
    }

}
