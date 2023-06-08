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
 * The table class for the &quot;SP_Offer&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Offer
 * @generated
 */
public class OfferTable extends BaseTable<OfferTable> {

	public static final OfferTable INSTANCE = new OfferTable();

	public final Column<OfferTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OfferTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> mobileData = createColumn(
		"mobileData", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> mobileMinutes = createColumn(
		"mobileMinutes", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> mobileSms = createColumn(
		"mobileSms", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> programsNumber = createColumn(
		"programsNumber", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> defaultNumberOfTvs = createColumn(
		"defaultNumberOfTvs", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> downloadSpeed = createColumn(
		"downloadSpeed", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> uploadSpeed = createColumn(
		"uploadSpeed", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> fullDurationMonths = createColumn(
		"fullDurationMonths", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> discountDurationMonths = createColumn(
		"discountDurationMonths", Long.class, Types.BIGINT,
		Column.FLAG_DEFAULT);
	public final Column<OfferTable, Double> basePrice = createColumn(
		"basePrice", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Double> discountPrice = createColumn(
		"discountPrice", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private OfferTable() {
		super("SP_Offer", OfferTable::new);
	}

}