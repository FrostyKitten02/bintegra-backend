/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package si.bintegra.sp.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConsultantService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConsultantService
 * @generated
 */
public class ConsultantServiceWrapper
	implements ConsultantService, ServiceWrapper<ConsultantService> {

	public ConsultantServiceWrapper() {
		this(null);
	}

	public ConsultantServiceWrapper(ConsultantService consultantService) {
		_consultantService = consultantService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _consultantService.getOSGiServiceIdentifier();
	}

	@Override
	public ConsultantService getWrappedService() {
		return _consultantService;
	}

	@Override
	public void setWrappedService(ConsultantService consultantService) {
		_consultantService = consultantService;
	}

	private ConsultantService _consultantService;

}