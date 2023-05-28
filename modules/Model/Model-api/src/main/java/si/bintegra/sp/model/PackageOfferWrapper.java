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

package si.bintegra.sp.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PackageOffer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PackageOffer
 * @generated
 */
public class PackageOfferWrapper
	extends BaseModelWrapper<PackageOffer>
	implements ModelWrapper<PackageOffer>, PackageOffer {

	public PackageOfferWrapper(PackageOffer packageOffer) {
		super(packageOffer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("packageId", getPackageId());
		attributes.put("fullDuration", getFullDuration());
		attributes.put("discountDuration", getDiscountDuration());
		attributes.put("basePrice", getBasePrice());
		attributes.put("discountPrice", getDiscountPrice());
		attributes.put("active", isActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long packageId = (Long)attributes.get("packageId");

		if (packageId != null) {
			setPackageId(packageId);
		}

		Long fullDuration = (Long)attributes.get("fullDuration");

		if (fullDuration != null) {
			setFullDuration(fullDuration);
		}

		Long discountDuration = (Long)attributes.get("discountDuration");

		if (discountDuration != null) {
			setDiscountDuration(discountDuration);
		}

		Double basePrice = (Double)attributes.get("basePrice");

		if (basePrice != null) {
			setBasePrice(basePrice);
		}

		Double discountPrice = (Double)attributes.get("discountPrice");

		if (discountPrice != null) {
			setDiscountPrice(discountPrice);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public PackageOffer cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this package offer.
	 *
	 * @return the active of this package offer
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the base price of this package offer.
	 *
	 * @return the base price of this package offer
	 */
	@Override
	public double getBasePrice() {
		return model.getBasePrice();
	}

	/**
	 * Returns the discount duration of this package offer.
	 *
	 * @return the discount duration of this package offer
	 */
	@Override
	public long getDiscountDuration() {
		return model.getDiscountDuration();
	}

	/**
	 * Returns the discount price of this package offer.
	 *
	 * @return the discount price of this package offer
	 */
	@Override
	public double getDiscountPrice() {
		return model.getDiscountPrice();
	}

	/**
	 * Returns the full duration of this package offer.
	 *
	 * @return the full duration of this package offer
	 */
	@Override
	public long getFullDuration() {
		return model.getFullDuration();
	}

	/**
	 * Returns the ID of this package offer.
	 *
	 * @return the ID of this package offer
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the package ID of this package offer.
	 *
	 * @return the package ID of this package offer
	 */
	@Override
	public long getPackageId() {
		return model.getPackageId();
	}

	/**
	 * Returns the primary key of this package offer.
	 *
	 * @return the primary key of this package offer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this package offer is active.
	 *
	 * @return <code>true</code> if this package offer is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this package offer is active.
	 *
	 * @param active the active of this package offer
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the base price of this package offer.
	 *
	 * @param basePrice the base price of this package offer
	 */
	@Override
	public void setBasePrice(double basePrice) {
		model.setBasePrice(basePrice);
	}

	/**
	 * Sets the discount duration of this package offer.
	 *
	 * @param discountDuration the discount duration of this package offer
	 */
	@Override
	public void setDiscountDuration(long discountDuration) {
		model.setDiscountDuration(discountDuration);
	}

	/**
	 * Sets the discount price of this package offer.
	 *
	 * @param discountPrice the discount price of this package offer
	 */
	@Override
	public void setDiscountPrice(double discountPrice) {
		model.setDiscountPrice(discountPrice);
	}

	/**
	 * Sets the full duration of this package offer.
	 *
	 * @param fullDuration the full duration of this package offer
	 */
	@Override
	public void setFullDuration(long fullDuration) {
		model.setFullDuration(fullDuration);
	}

	/**
	 * Sets the ID of this package offer.
	 *
	 * @param id the ID of this package offer
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the package ID of this package offer.
	 *
	 * @param packageId the package ID of this package offer
	 */
	@Override
	public void setPackageId(long packageId) {
		model.setPackageId(packageId);
	}

	/**
	 * Sets the primary key of this package offer.
	 *
	 * @param primaryKey the primary key of this package offer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PackageOfferWrapper wrap(PackageOffer packageOffer) {
		return new PackageOfferWrapper(packageOffer);
	}

}