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
 * This class is a wrapper for {@link Offer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Offer
 * @generated
 */
public class OfferWrapper
	extends BaseModelWrapper<Offer> implements ModelWrapper<Offer>, Offer {

	public OfferWrapper(Offer offer) {
		super(offer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("type", getType());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("mobileData", getMobileData());
		attributes.put("mobileMinutes", getMobileMinutes());
		attributes.put("mobileSms", getMobileSms());
		attributes.put("programsNumber", getProgramsNumber());
		attributes.put("defaultNumberOfTvs", getDefaultNumberOfTvs());
		attributes.put("downloadSpeed", getDownloadSpeed());
		attributes.put("uploadSpeed", getUploadSpeed());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long mobileData = (Long)attributes.get("mobileData");

		if (mobileData != null) {
			setMobileData(mobileData);
		}

		Long mobileMinutes = (Long)attributes.get("mobileMinutes");

		if (mobileMinutes != null) {
			setMobileMinutes(mobileMinutes);
		}

		Long mobileSms = (Long)attributes.get("mobileSms");

		if (mobileSms != null) {
			setMobileSms(mobileSms);
		}

		Long programsNumber = (Long)attributes.get("programsNumber");

		if (programsNumber != null) {
			setProgramsNumber(programsNumber);
		}

		Long defaultNumberOfTvs = (Long)attributes.get("defaultNumberOfTvs");

		if (defaultNumberOfTvs != null) {
			setDefaultNumberOfTvs(defaultNumberOfTvs);
		}

		Long downloadSpeed = (Long)attributes.get("downloadSpeed");

		if (downloadSpeed != null) {
			setDownloadSpeed(downloadSpeed);
		}

		Long uploadSpeed = (Long)attributes.get("uploadSpeed");

		if (uploadSpeed != null) {
			setUploadSpeed(uploadSpeed);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public Offer cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this offer.
	 *
	 * @return the active of this offer
	 */
	@Override
	public Boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the default number of tvs of this offer.
	 *
	 * @return the default number of tvs of this offer
	 */
	@Override
	public Long getDefaultNumberOfTvs() {
		return model.getDefaultNumberOfTvs();
	}

	/**
	 * Returns the description of this offer.
	 *
	 * @return the description of this offer
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the download speed of this offer.
	 *
	 * @return the download speed of this offer
	 */
	@Override
	public Long getDownloadSpeed() {
		return model.getDownloadSpeed();
	}

	/**
	 * Returns the ID of this offer.
	 *
	 * @return the ID of this offer
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the mobile data of this offer.
	 *
	 * @return the mobile data of this offer
	 */
	@Override
	public Long getMobileData() {
		return model.getMobileData();
	}

	/**
	 * Returns the mobile minutes of this offer.
	 *
	 * @return the mobile minutes of this offer
	 */
	@Override
	public Long getMobileMinutes() {
		return model.getMobileMinutes();
	}

	/**
	 * Returns the mobile sms of this offer.
	 *
	 * @return the mobile sms of this offer
	 */
	@Override
	public Long getMobileSms() {
		return model.getMobileSms();
	}

	/**
	 * Returns the primary key of this offer.
	 *
	 * @return the primary key of this offer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the programs number of this offer.
	 *
	 * @return the programs number of this offer
	 */
	@Override
	public Long getProgramsNumber() {
		return model.getProgramsNumber();
	}

	/**
	 * Returns the title of this offer.
	 *
	 * @return the title of this offer
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type of this offer.
	 *
	 * @return the type of this offer
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the upload speed of this offer.
	 *
	 * @return the upload speed of this offer
	 */
	@Override
	public Long getUploadSpeed() {
		return model.getUploadSpeed();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the active of this offer.
	 *
	 * @param active the active of this offer
	 */
	@Override
	public void setActive(Boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the default number of tvs of this offer.
	 *
	 * @param defaultNumberOfTvs the default number of tvs of this offer
	 */
	@Override
	public void setDefaultNumberOfTvs(Long defaultNumberOfTvs) {
		model.setDefaultNumberOfTvs(defaultNumberOfTvs);
	}

	/**
	 * Sets the description of this offer.
	 *
	 * @param description the description of this offer
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the download speed of this offer.
	 *
	 * @param downloadSpeed the download speed of this offer
	 */
	@Override
	public void setDownloadSpeed(Long downloadSpeed) {
		model.setDownloadSpeed(downloadSpeed);
	}

	/**
	 * Sets the ID of this offer.
	 *
	 * @param id the ID of this offer
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the mobile data of this offer.
	 *
	 * @param mobileData the mobile data of this offer
	 */
	@Override
	public void setMobileData(Long mobileData) {
		model.setMobileData(mobileData);
	}

	/**
	 * Sets the mobile minutes of this offer.
	 *
	 * @param mobileMinutes the mobile minutes of this offer
	 */
	@Override
	public void setMobileMinutes(Long mobileMinutes) {
		model.setMobileMinutes(mobileMinutes);
	}

	/**
	 * Sets the mobile sms of this offer.
	 *
	 * @param mobileSms the mobile sms of this offer
	 */
	@Override
	public void setMobileSms(Long mobileSms) {
		model.setMobileSms(mobileSms);
	}

	/**
	 * Sets the primary key of this offer.
	 *
	 * @param primaryKey the primary key of this offer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the programs number of this offer.
	 *
	 * @param programsNumber the programs number of this offer
	 */
	@Override
	public void setProgramsNumber(Long programsNumber) {
		model.setProgramsNumber(programsNumber);
	}

	/**
	 * Sets the title of this offer.
	 *
	 * @param title the title of this offer
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type of this offer.
	 *
	 * @param type the type of this offer
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the upload speed of this offer.
	 *
	 * @param uploadSpeed the upload speed of this offer
	 */
	@Override
	public void setUploadSpeed(Long uploadSpeed) {
		model.setUploadSpeed(uploadSpeed);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected OfferWrapper wrap(Offer offer) {
		return new OfferWrapper(offer);
	}

}