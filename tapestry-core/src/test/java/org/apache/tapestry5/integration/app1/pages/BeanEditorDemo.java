// Copyright 2007, 2010, 2011 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.tapestry5.integration.app1.pages;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.ClientValidation;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.integration.app1.data.RegistrationData;

public class BeanEditorDemo
{
    @Persist(PersistenceConstants.FLASH)
    private String message;

    @Component(id = "registrationData", parameters =
    { "clientValidation=prop:clientValidation" })
    private BeanEditForm form;

    @SessionState
    @Property
    private RegistrationData registrationData;

    @Property
    @Validate("required")
    private String searchTerm;

    Object onSuccess()
    {
        return ViewRegistration.class;
    }

    void onActionFromClear()
    {
        registrationData = null;
        form.clearErrors();
    }

    public ClientValidation getClientValidation()
    {
        return ClientValidation.NONE;
    }

    public String getPageTitle()
    {
        return "BeanEditor Component Demo";
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    protected void clearErrors()
    {
        form.clearErrors();
    }
}
