/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package de.uhh.l2g.plugins.model.impl;

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

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.HostModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Host service. Represents a row in the &quot;LG_Host&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.uhh.l2g.plugins.model.HostModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HostImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see HostImpl
 * @see de.uhh.l2g.plugins.model.Host
 * @see de.uhh.l2g.plugins.model.HostModel
 * @generated
 */
public class HostModelImpl extends BaseModelImpl<Host> implements HostModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a host model instance should use the {@link de.uhh.l2g.plugins.model.Host} interface instead.
	 */
	public static final String TABLE_NAME = "LG_Host";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hostId", Types.BIGINT },
			{ "protocol", Types.VARCHAR },
			{ "streamer", Types.VARCHAR },
			{ "port", Types.INTEGER },
			{ "serverRoot", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "serverTemplate", Types.VARCHAR },
			{ "groupId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table LG_Host (hostId LONG not null primary key,protocol VARCHAR(75) null,streamer VARCHAR(75) null,port INTEGER,serverRoot VARCHAR(75) null,name VARCHAR(75) null,serverTemplate VARCHAR(75) null,groupId LONG)";
	public static final String TABLE_SQL_DROP = "drop table LG_Host";
	public static final String ORDER_BY_JPQL = " ORDER BY host.hostId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LG_Host.hostId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.Host"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.Host"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.de.uhh.l2g.plugins.model.Host"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long HOSTID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.de.uhh.l2g.plugins.model.Host"));

	public HostModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _hostId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _hostId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Host.class;
	}

	@Override
	public String getModelClassName() {
		return Host.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("hostId", getHostId());
		attributes.put("protocol", getProtocol());
		attributes.put("streamer", getStreamer());
		attributes.put("port", getPort());
		attributes.put("serverRoot", getServerRoot());
		attributes.put("name", getName());
		attributes.put("serverTemplate", getServerTemplate());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		String protocol = (String)attributes.get("protocol");

		if (protocol != null) {
			setProtocol(protocol);
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

		String serverTemplate = (String)attributes.get("serverTemplate");

		if (serverTemplate != null) {
			setServerTemplate(serverTemplate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public long getHostId() {
		return _hostId;
	}

	@Override
	public void setHostId(long hostId) {
		_hostId = hostId;
	}

	@Override
	public String getProtocol() {
		if (_protocol == null) {
			return StringPool.BLANK;
		}
		else {
			return _protocol;
		}
	}

	@Override
	public void setProtocol(String protocol) {
		_protocol = protocol;
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
	public String getServerTemplate() {
		if (_serverTemplate == null) {
			return StringPool.BLANK;
		}
		else {
			return _serverTemplate;
		}
	}

	@Override
	public void setServerTemplate(String serverTemplate) {
		_serverTemplate = serverTemplate;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Host.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Host toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Host)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		HostImpl hostImpl = new HostImpl();

		hostImpl.setHostId(getHostId());
		hostImpl.setProtocol(getProtocol());
		hostImpl.setStreamer(getStreamer());
		hostImpl.setPort(getPort());
		hostImpl.setServerRoot(getServerRoot());
		hostImpl.setName(getName());
		hostImpl.setServerTemplate(getServerTemplate());
		hostImpl.setGroupId(getGroupId());

		hostImpl.resetOriginalValues();

		return hostImpl;
	}

	@Override
	public int compareTo(Host host) {
		long primaryKey = host.getPrimaryKey();

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

		if (!(obj instanceof Host)) {
			return false;
		}

		Host host = (Host)obj;

		long primaryKey = host.getPrimaryKey();

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
		HostModelImpl hostModelImpl = this;

		hostModelImpl._originalGroupId = hostModelImpl._groupId;

		hostModelImpl._setOriginalGroupId = false;

		hostModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Host> toCacheModel() {
		HostCacheModel hostCacheModel = new HostCacheModel();

		hostCacheModel.hostId = getHostId();

		hostCacheModel.protocol = getProtocol();

		String protocol = hostCacheModel.protocol;

		if ((protocol != null) && (protocol.length() == 0)) {
			hostCacheModel.protocol = null;
		}

		hostCacheModel.streamer = getStreamer();

		String streamer = hostCacheModel.streamer;

		if ((streamer != null) && (streamer.length() == 0)) {
			hostCacheModel.streamer = null;
		}

		hostCacheModel.port = getPort();

		hostCacheModel.serverRoot = getServerRoot();

		String serverRoot = hostCacheModel.serverRoot;

		if ((serverRoot != null) && (serverRoot.length() == 0)) {
			hostCacheModel.serverRoot = null;
		}

		hostCacheModel.name = getName();

		String name = hostCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			hostCacheModel.name = null;
		}

		hostCacheModel.serverTemplate = getServerTemplate();

		String serverTemplate = hostCacheModel.serverTemplate;

		if ((serverTemplate != null) && (serverTemplate.length() == 0)) {
			hostCacheModel.serverTemplate = null;
		}

		hostCacheModel.groupId = getGroupId();

		return hostCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{hostId=");
		sb.append(getHostId());
		sb.append(", protocol=");
		sb.append(getProtocol());
		sb.append(", streamer=");
		sb.append(getStreamer());
		sb.append(", port=");
		sb.append(getPort());
		sb.append(", serverRoot=");
		sb.append(getServerRoot());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", serverTemplate=");
		sb.append(getServerTemplate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Host");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hostId</column-name><column-value><![CDATA[");
		sb.append(getHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>protocol</column-name><column-value><![CDATA[");
		sb.append(getProtocol());
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
		sb.append(
			"<column><column-name>serverTemplate</column-name><column-value><![CDATA[");
		sb.append(getServerTemplate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Host.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Host.class };
	private long _hostId;
	private String _protocol;
	private String _streamer;
	private int _port;
	private String _serverRoot;
	private String _name;
	private String _serverTemplate;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _columnBitmask;
	private Host _escapedModel;
}