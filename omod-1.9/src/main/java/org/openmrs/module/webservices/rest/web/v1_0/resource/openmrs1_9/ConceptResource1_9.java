/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_9;

import org.openmrs.Concept;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.RepHandler;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ConversionException;
import org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_8.ConceptResource1_8;


/**
 * Implemented to increase the resource version since the mapping subresource changed.
 */
@Resource(name = RestConstants.VERSION_1 + "/concept", supportedClass = Concept.class, supportedOpenmrsVersions = "1.9.*")
public class ConceptResource1_9 extends ConceptResource1_8 {
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#getResourceVersion()
	 */
	@Override
	public String getResourceVersion() {
	    return RestConstants1_9.RESOURCE_VERSION;
	}

    @RepHandler(FullRepresentation.class)
    public SimpleObject asFull(Concept delegate) throws ConversionException {
        DelegatingResourceDescription description = super.fullRepresentationDescription(delegate);
        description.removeProperty("setMembers");
        description.addProperty("setMembers", Representation.FULL);

        return convertDelegateToRepresentation(delegate, description);
    }
}
