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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.osgi.service.component.annotations.Component;

import si.bintegra.sp.exception.NoSuchConsultantException;
import si.bintegra.sp.model.ConsultantCustomer;
import si.bintegra.sp.model.ConsultantCustomerModel;
import si.bintegra.sp.model.ConsultantModel;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.service.base.ConsultantCustomerLocalServiceBaseImpl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=si.bintegra.sp.model.ConsultantCustomer",
	service = AopService.class
)
public class ConsultantCustomerLocalServiceImpl
	extends ConsultantCustomerLocalServiceBaseImpl {

	public void assignConsultantToCustomer(Long customerUserId) {
		List<ConsultantCustomer> customerConsultats = consultantCustomerPersistence.findBycustomerId(customerUserId);
		if (customerConsultats.size() > 0) {
			//customer alredy has a consultant
			return;
		}

		List<Long> allConsultants = consultantPersistence.findAll().stream().map(ConsultantModel::getUserId).collect(Collectors.toList());
		List<ConsultantAndCustomerNumber> consultantNumberOfCustomers = new ArrayList<>();

		for (Long cid : allConsultants) {
			int size = consultantCustomerPersistence.findByconsultantId(cid).size();
			if (size == 0) {
				long newId = counterLocalService.increment();
				ConsultantCustomer cc = consultantCustomerPersistence.create(newId);

				cc.setConsultantId(cid);
				cc.setCustomerId(customerUserId);

				consultantCustomerPersistence.update(cc);
				return;
			}
			consultantNumberOfCustomers.add(new ConsultantAndCustomerNumber(cid, size));
		}

		consultantNumberOfCustomers.sort(Comparator.comparingInt(ConsultantAndCustomerNumber::getNumberOfCustomers));

		Long consultantId = consultantNumberOfCustomers.get(0).getConsultantId();
		long newId = counterLocalService.increment();
		ConsultantCustomer cc = consultantCustomerPersistence.create(newId);

		cc.setConsultantId(consultantId);
		cc.setCustomerId(customerUserId);

		consultantCustomerPersistence.update(cc);
	}

	public List<Long> getConsultantCustomerIdsByConsultantUserId(long userId) throws NoSuchConsultantException {
		return consultantCustomerPersistence.findByconsultantId(userId).stream().map(ConsultantCustomerModel::getCustomerId).collect(Collectors.toList());
	}


	@Getter
	@Setter
	@AllArgsConstructor
	static class ConsultantAndCustomerNumber {
		private Long consultantId;
		private int numberOfCustomers;
	}

}