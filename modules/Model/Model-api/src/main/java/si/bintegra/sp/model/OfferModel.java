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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Offer service. Represents a row in the &quot;SP_Offer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>si.bintegra.sp.model.impl.OfferModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>si.bintegra.sp.model.impl.OfferImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Offer
 * @generated
 */
@ProviderType
public interface OfferModel extends BaseModel<Offer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a offer model instance should use the {@link Offer} interface instead.
	 */

	/**
	 * Returns the primary key of this offer.
	 *
	 * @return the primary key of this offer
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this offer.
	 *
	 * @param primaryKey the primary key of this offer
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this offer.
	 *
	 * @return the ID of this offer
	 */
	public long getId();

	/**
	 * Sets the ID of this offer.
	 *
	 * @param id the ID of this offer
	 */
	public void setId(long id);

	/**
	 * Returns the type of this offer.
	 *
	 * @return the type of this offer
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this offer.
	 *
	 * @param type the type of this offer
	 */
	public void setType(String type);

	/**
	 * Returns the title of this offer.
	 *
	 * @return the title of this offer
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this offer.
	 *
	 * @param title the title of this offer
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this offer.
	 *
	 * @return the description of this offer
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this offer.
	 *
	 * @param description the description of this offer
	 */
	public void setDescription(String description);

	/**
	 * Returns the mobile data of this offer.
	 *
	 * @return the mobile data of this offer
	 */
	public Long getMobileData();

	/**
	 * Sets the mobile data of this offer.
	 *
	 * @param mobileData the mobile data of this offer
	 */
	public void setMobileData(Long mobileData);

	/**
	 * Returns the mobile minutes of this offer.
	 *
	 * @return the mobile minutes of this offer
	 */
	public Long getMobileMinutes();

	/**
	 * Sets the mobile minutes of this offer.
	 *
	 * @param mobileMinutes the mobile minutes of this offer
	 */
	public void setMobileMinutes(Long mobileMinutes);

	/**
	 * Returns the mobile sms of this offer.
	 *
	 * @return the mobile sms of this offer
	 */
	public Long getMobileSms();

	/**
	 * Sets the mobile sms of this offer.
	 *
	 * @param mobileSms the mobile sms of this offer
	 */
	public void setMobileSms(Long mobileSms);

	/**
	 * Returns the programs number of this offer.
	 *
	 * @return the programs number of this offer
	 */
	public Long getProgramsNumber();

	/**
	 * Sets the programs number of this offer.
	 *
	 * @param programsNumber the programs number of this offer
	 */
	public void setProgramsNumber(Long programsNumber);

	/**
	 * Returns the default number of tvs of this offer.
	 *
	 * @return the default number of tvs of this offer
	 */
	public Long getDefaultNumberOfTvs();

	/**
	 * Sets the default number of tvs of this offer.
	 *
	 * @param defaultNumberOfTvs the default number of tvs of this offer
	 */
	public void setDefaultNumberOfTvs(Long defaultNumberOfTvs);

	/**
	 * Returns the download speed of this offer.
	 *
	 * @return the download speed of this offer
	 */
	public Long getDownloadSpeed();

	/**
	 * Sets the download speed of this offer.
	 *
	 * @param downloadSpeed the download speed of this offer
	 */
	public void setDownloadSpeed(Long downloadSpeed);

	/**
	 * Returns the upload speed of this offer.
	 *
	 * @return the upload speed of this offer
	 */
	public Long getUploadSpeed();

	/**
	 * Sets the upload speed of this offer.
	 *
	 * @param uploadSpeed the upload speed of this offer
	 */
	public void setUploadSpeed(Long uploadSpeed);

	/**
	 * Returns the active of this offer.
	 *
	 * @return the active of this offer
	 */
	public Boolean getActive();

	/**
	 * Sets the active of this offer.
	 *
	 * @param active the active of this offer
	 */
	public void setActive(Boolean active);

	@Override
	public Offer cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}