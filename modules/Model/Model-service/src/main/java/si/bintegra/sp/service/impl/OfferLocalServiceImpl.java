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

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.service.base.OfferLocalServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=si.bintegra.sp.model.Offer",
	service = AopService.class
)
public class OfferLocalServiceImpl extends OfferLocalServiceBaseImpl {
	public List<Offer> findActiveByType(String type) {
		return offerPersistence.findBytypeAndActive(type, true);
	}

	public Offer findById(long id) throws NoSuchOfferException {
		return offerPersistence.findByPrimaryKey(id);
	}

	public Offer addOffer(String title, String type, String description, Boolean active, Long mobileData, Long mobileMinutes, Long mobileSms, Long programsNumber, Long defaultNumberOfTvs, Long downloadSpeed, Long uploadSpeed, Long fullDurationMonths, Long discountDurationMonths, Double basePrice, Double discountPrice) {
		long newId = counterLocalService.increment();
		Offer offer = offerPersistence.create(newId);

		offer.setTitle(title);
		offer.setType(type);
		offer.setDescription(description);
		offer.setActive(active);
		offer.setMobileData(mobileData);
		offer.setMobileMinutes(mobileMinutes);
		offer.setMobileSms(mobileSms);
		offer.setProgramsNumber(programsNumber);
		offer.setDefaultNumberOfTvs(defaultNumberOfTvs);
		offer.setDownloadSpeed(downloadSpeed);
		offer.setUploadSpeed(uploadSpeed);
		offer.setFullDurationMonths(fullDurationMonths);
		offer.setDiscountDurationMonths(discountDurationMonths);
		offer.setBasePrice(basePrice);
		offer.setDiscountPrice(discountPrice);

		return offerPersistence.update(offer);
	}

	public List<Offer> findByType(String type) {
		return offerPersistence.findBytype(type);
	}
}