/*
 * Copyright (c) 2019 Christian Kaltepoth
 * Copyright (c) 2019, 2025 Contributors to the Eclipse Foundation
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
package ee.jakarta.tck.mvc.tests.security.csrf.base;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.MvcContext;
import jakarta.mvc.security.CsrfProtected;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Controller
@Path("csrf/base")
public class CsrfBaseController {

    @Inject
    private MvcContext mvcContext;

    @Inject
    private Models models;

    @GET
    @CsrfProtected
    public String render() {
        models.put("injectedCsrf", mvcContext.getCsrf());
        return "csrf/base/base.jsp";
    }

}
