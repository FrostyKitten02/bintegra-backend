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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;SP_ConsultantCustomer&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ConsultantCustomer
 * @generated
 */
public class ConsultantCustomerTable
	extends BaseTable<ConsultantCustomerTable> {

	public static final ConsultantCustomerTable INSTANCE =
		new ConsultantCustomerTable();

	public final Column<ConsultantCustomerTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ConsultantCustomerTable, Long> consultantId =
		createColumn(
			"consultantId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ConsultantCustomerTable, Long> customerId =
		createColumn(
			"customerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ConsultantCustomerTable() {
		super("SP_ConsultantCustomer", ConsultantCustomerTable::new);
	}

}