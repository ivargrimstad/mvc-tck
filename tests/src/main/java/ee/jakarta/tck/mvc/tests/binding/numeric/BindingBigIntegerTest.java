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
package ee.jakarta.tck.mvc.tests.binding.numeric;

import com.gargoylesoftware.htmlunit.Page;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecAssertions;
import org.jboss.test.audit.annotations.SpecVersion;
import org.junit.Test;
import org.junit.runner.RunWith;
import ee.jakarta.tck.mvc.Sections;
import ee.jakarta.tck.mvc.util.Archives;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
@SpecVersion(spec = "mvc", version = "1.0")
public class BindingBigIntegerTest extends AbstractNumericTest {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return Archives.getMvcArchive()
                .addClass(ForceGermanLocaleResolver.class)
                .addClass(BindingBigIntegerController.class)
                .addClass(BindingBigIntegerForm.class)
                .addView("binding/numeric/form.jsp")
                .addView("binding/numeric/result.jsp")
                .build();
    }


    @Test
    @SpecAssertions({
            @SpecAssertion(section = Sections.BINDING_NUMERIC_TYPE, id = "convert-numeric")
    })
    public void submitValidBigInteger() throws IOException {

        Page resultPage = submitForm("binding/numeric", "1.234");

        assertThat(resultPage.getWebResponse().getStatusCode(), equalTo(200));
        assertThat(resultPage.getWebResponse().getContentAsString(), containsString("Object: [1234]"));

    }

    @Test
    @SpecAssertions({
            @SpecAssertion(section = Sections.BINDING_NUMERIC_TYPE, id = "convert-empty-numeric")
    })
    public void submitEmptyBigInteger() throws IOException {

        Page resultPage = submitForm("binding/numeric", "");

        assertThat(resultPage.getWebResponse().getStatusCode(), equalTo(200));
        assertThat(resultPage.getWebResponse().getContentAsString(), containsString("Object: [null]"));

    }

}
