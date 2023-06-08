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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ConsultantCustomer service. Represents a row in the &quot;SP_ConsultantCustomer&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ConsultantCustomerModel
 * @generated
 */
@ImplementationClassName("si.bintegra.sp.model.impl.ConsultantCustomerImpl")
@ProviderType
public interface ConsultantCustomer
	extends ConsultantCustomerModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>si.bintegra.sp.model.impl.ConsultantCustomerImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ConsultantCustomer, Long> ID_ACCESSOR =
		new Accessor<ConsultantCustomer, Long>() {

			@Override
			public Long get(ConsultantCustomer consultantCustomer) {
				return consultantCustomer.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ConsultantCustomer> getTypeClass() {
				return ConsultantCustomer.class;
			}

		};

}