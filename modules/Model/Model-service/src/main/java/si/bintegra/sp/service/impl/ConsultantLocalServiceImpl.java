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

package si.bintegra.sp.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import si.bintegra.sp.exception.NoSuchConsultantException;
import si.bintegra.sp.model.Consultant;
import si.bintegra.sp.service.base.ConsultantLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=si.bintegra.sp.model.Consultant",
	service = AopService.class
)
public class ConsultantLocalServiceImpl extends ConsultantLocalServiceBaseImpl {

	public void addConsultant(Long userId) {
		long newId = counterLocalService.increment();
		Consultant consultant = consultantPersistence.create(newId);

		consultant.setUserId(userId);

		consultantPersistence.update(consultant);
	}

	public Consultant getConsultantByUserId(Long userId) {
		try {
			return consultantPersistence.findByuserId(userId);
		} catch (NoSuchConsultantException e) {
			return null;
		}
	}
}