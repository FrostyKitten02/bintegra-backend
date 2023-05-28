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
 * The table class for the &quot;SP_PackageOffer&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PackageOffer
 * @generated
 */
public class PackageOfferTable extends BaseTable<PackageOfferTable> {

	public static final PackageOfferTable INSTANCE = new PackageOfferTable();

	public final Column<PackageOfferTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PackageOfferTable, Long> packageId = createColumn(
		"packageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PackageOfferTable, Long> fullDuration = createColumn(
		"fullDuration", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PackageOfferTable, Long> discountDuration =
		createColumn(
			"discountDuration", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PackageOfferTable, Double> basePrice = createColumn(
		"basePrice", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<PackageOfferTable, Double> discountPrice = createColumn(
		"discountPrice", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<PackageOfferTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private PackageOfferTable() {
		super("SP_PackageOffer", PackageOfferTable::new);
	}

}