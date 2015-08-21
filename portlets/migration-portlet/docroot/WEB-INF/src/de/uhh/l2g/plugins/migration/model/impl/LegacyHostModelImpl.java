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

package de.uhh.l2g.plugins.migration.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyHost;
import de.uhh.l2g.plugins.migration.model.LegacyHostModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the LegacyHost service. Represents a row in the &quot;host&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.uhh.l2g.plugins.migration.model.LegacyHostModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LegacyHostImpl}.
 * </p>
 *
 * @author unihh
 * @see LegacyHostImpl
 * @see de.uhh.l2g.plugins.migration.model.LegacyHost
 * @see de.uhh.l2g.plugins.migration.model.LegacyHostModel
 * @generated
 */
public class LegacyHostModelImpl extends BaseModelImpl<LegacyHost>
	implements LegacyHostModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a legacy host model instance should use the {@link de.uhh.l2g.plugins.migration.model.LegacyHost} interface instead.
	 */
	public static final String TABLE_NAME = "host";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "protokoll", Types.VARCHAR },
			{ "streamer", Types.VARCHAR },
			{ "port", Types.INTEGER },
			{ "serverRoot", Types.VARCHAR },
			{ "name", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table host (id_ LONG not null primary key,protokoll VARCHAR(75) null,streamer VARCHAR(75) null,port INTEGER,serverRoot VARCHAR(75) null,name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table host";
	public static final String ORDER_BY_JPQL = " ORDER BY legacyHost.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY host.id_ ASC";
	public static final String DATA_SOURCE = "anotherDataSource";
	public static final String SESSION_FACTORY = "anotherSessionFactory";
	public static final String TX_MANAGER = "anotherTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.de.uhh.l2g.plugins.migration.model.LegacyHost"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.de.uhh.l2g.plugins.migration.model.LegacyHost"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.de.uhh.l2g.plugins.migration.model.LegacyHost"));

	public LegacyHostModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyHost.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyHost.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("protokoll", getProtokoll());
		attributes.put("streamer", getStreamer());
		attributes.put("port", getPort());
		attributes.put("serverRoot", getServerRoot());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String protokoll = (String)attributes.get("protokoll");

		if (protokoll != null) {
			setProtokoll(protokoll);
		}

		String streamer = (String)attributes.get("streamer");

		if (streamer != null) {
			setStreamer(streamer);
		}

		Integer port = (Integer)attributes.get("port");

		if (port != null) {
			setPort(port);
		}

		String serverRoot = (String)attributes.get("serverRoot");

		if (serverRoot != null) {
			setServerRoot(serverRoot);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public String getProtokoll() {
		if (_protokoll == null) {
			return StringPool.BLANK;
		}
		else {
			return _protokoll;
		}
	}

	@Override
	public void setProtokoll(String protokoll) {
		_protokoll = protokoll;
	}

	@Override
	public String getStreamer() {
		if (_streamer == null) {
			return StringPool.BLANK;
		}
		else {
			return _streamer;
		}
	}

	@Override
	public void setStreamer(String streamer) {
		_streamer = streamer;
	}

	@Override
	public int getPort() {
		return _port;
	}

	@Override
	public void setPort(int port) {
		_port = port;
	}

	@Override
	public String getServerRoot() {
		if (_serverRoot == null) {
			return StringPool.BLANK;
		}
		else {
			return _serverRoot;
		}
	}

	@Override
	public void setServerRoot(String serverRoot) {
		_serverRoot = serverRoot;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			LegacyHost.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LegacyHost toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LegacyHost)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LegacyHostImpl legacyHostImpl = new LegacyHostImpl();

		legacyHostImpl.setId(getId());
		legacyHostImpl.setProtokoll(getProtokoll());
		legacyHostImpl.setStreamer(getStreamer());
		legacyHostImpl.setPort(getPort());
		legacyHostImpl.setServerRoot(getServerRoot());
		legacyHostImpl.setName(getName());

		legacyHostImpl.resetOriginalValues();

		return legacyHostImpl;
	}

	@Override
	public int compareTo(LegacyHost legacyHost) {
		long primaryKey = legacyHost.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyHost)) {
			return false;
		}

		LegacyHost legacyHost = (LegacyHost)obj;

		long primaryKey = legacyHost.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<LegacyHost> toCacheModel() {
		LegacyHostCacheModel legacyHostCacheModel = new LegacyHostCacheModel();

		legacyHostCacheModel.id = getId();

		legacyHostCacheModel.protokoll = getProtokoll();

		String protokoll = legacyHostCacheModel.protokoll;

		if ((protokoll != null) && (protokoll.length() == 0)) {
			legacyHostCacheModel.protokoll = null;
		}

		legacyHostCacheModel.streamer = getStreamer();

		String streamer = legacyHostCacheModel.streamer;

		if ((streamer != null) && (streamer.length() == 0)) {
			legacyHostCacheModel.streamer = null;
		}

		legacyHostCacheModel.port = getPort();

		legacyHostCacheModel.serverRoot = getServerRoot();

		String serverRoot = legacyHostCacheModel.serverRoot;

		if ((serverRoot != null) && (serverRoot.length() == 0)) {
			legacyHostCacheModel.serverRoot = null;
		}

		legacyHostCacheModel.name = getName();

		String name = legacyHostCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			legacyHostCacheModel.name = null;
		}

		return legacyHostCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", protokoll=");
		sb.append(getProtokoll());
		sb.append(", streamer=");
		sb.append(getStreamer());
		sb.append(", port=");
		sb.append(getPort());
		sb.append(", serverRoot=");
		sb.append(getServerRoot());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyHost");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>protokoll</column-name><column-value><![CDATA[");
		sb.append(getProtokoll());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>streamer</column-name><column-value><![CDATA[");
		sb.append(getStreamer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>port</column-name><column-value><![CDATA[");
		sb.append(getPort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serverRoot</column-name><column-value><![CDATA[");
		sb.append(getServerRoot());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = LegacyHost.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			LegacyHost.class
		};
	private long _id;
	private String _protokoll;
	private String _streamer;
	private int _port;
	private String _serverRoot;
	private String _name;
	private LegacyHost _escapedModel;
}