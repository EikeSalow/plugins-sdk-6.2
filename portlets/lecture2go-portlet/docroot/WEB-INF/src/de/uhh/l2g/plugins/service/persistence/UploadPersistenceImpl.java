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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.NoSuchUploadException;
import de.uhh.l2g.plugins.model.Upload;
import de.uhh.l2g.plugins.model.impl.UploadImpl;
import de.uhh.l2g.plugins.model.impl.UploadModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the upload service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see UploadPersistence
 * @see UploadUtil
 * @generated
 */
public class UploadPersistenceImpl extends BasePersistenceImpl<Upload>
	implements UploadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UploadUtil} to access the upload persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UploadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UploadModelImpl.ENTITY_CACHE_ENABLED,
			UploadModelImpl.FINDER_CACHE_ENABLED, UploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UploadModelImpl.ENTITY_CACHE_ENABLED,
			UploadModelImpl.FINDER_CACHE_ENABLED, UploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UploadModelImpl.ENTITY_CACHE_ENABLED,
			UploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(UploadModelImpl.ENTITY_CACHE_ENABLED,
			UploadModelImpl.FINDER_CACHE_ENABLED, UploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(UploadModelImpl.ENTITY_CACHE_ENABLED,
			UploadModelImpl.FINDER_CACHE_ENABLED, UploadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName() },
			UploadModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(UploadModelImpl.ENTITY_CACHE_ENABLED,
			UploadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the uploads where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Upload> findByVideo(long videoId) throws SystemException {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the uploads where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.UploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of uploads
	 * @param end the upper bound of the range of uploads (not inclusive)
	 * @return the range of matching uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Upload> findByVideo(long videoId, int start, int end)
		throws SystemException {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the uploads where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.UploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of uploads
	 * @param end the upper bound of the range of uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Upload> findByVideo(long videoId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId, start, end, orderByComparator };
		}

		List<Upload> list = (List<Upload>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Upload upload : list) {
				if ((videoId != upload.getVideoId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_UPLOAD_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UploadModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Upload>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Upload>(list);
				}
				else {
					list = (List<Upload>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first upload in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload
	 * @throws de.uhh.l2g.plugins.NoSuchUploadException if a matching upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload findByVideo_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchUploadException, SystemException {
		Upload upload = fetchByVideo_First(videoId, orderByComparator);

		if (upload != null) {
			return upload;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUploadException(msg.toString());
	}

	/**
	 * Returns the first upload in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching upload, or <code>null</code> if a matching upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload fetchByVideo_First(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Upload> list = findByVideo(videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last upload in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload
	 * @throws de.uhh.l2g.plugins.NoSuchUploadException if a matching upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload findByVideo_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchUploadException, SystemException {
		Upload upload = fetchByVideo_Last(videoId, orderByComparator);

		if (upload != null) {
			return upload;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUploadException(msg.toString());
	}

	/**
	 * Returns the last upload in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching upload, or <code>null</code> if a matching upload could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload fetchByVideo_Last(long videoId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Upload> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the uploads before and after the current upload in the ordered set where videoId = &#63;.
	 *
	 * @param uploadId the primary key of the current upload
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next upload
	 * @throws de.uhh.l2g.plugins.NoSuchUploadException if a upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload[] findByVideo_PrevAndNext(long uploadId, long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchUploadException, SystemException {
		Upload upload = findByPrimaryKey(uploadId);

		Session session = null;

		try {
			session = openSession();

			Upload[] array = new UploadImpl[3];

			array[0] = getByVideo_PrevAndNext(session, upload, videoId,
					orderByComparator, true);

			array[1] = upload;

			array[2] = getByVideo_PrevAndNext(session, upload, videoId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Upload getByVideo_PrevAndNext(Session session, Upload upload,
		long videoId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UPLOAD_WHERE);

		query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UploadModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(upload);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Upload> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the uploads where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVideo(long videoId) throws SystemException {
		for (Upload upload : findByVideo(videoId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(upload);
		}
	}

	/**
	 * Returns the number of uploads where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVideo(long videoId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPLOAD_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "upload.videoId = ?";

	public UploadPersistenceImpl() {
		setModelClass(Upload.class);
	}

	/**
	 * Caches the upload in the entity cache if it is enabled.
	 *
	 * @param upload the upload
	 */
	@Override
	public void cacheResult(Upload upload) {
		EntityCacheUtil.putResult(UploadModelImpl.ENTITY_CACHE_ENABLED,
			UploadImpl.class, upload.getPrimaryKey(), upload);

		upload.resetOriginalValues();
	}

	/**
	 * Caches the uploads in the entity cache if it is enabled.
	 *
	 * @param uploads the uploads
	 */
	@Override
	public void cacheResult(List<Upload> uploads) {
		for (Upload upload : uploads) {
			if (EntityCacheUtil.getResult(
						UploadModelImpl.ENTITY_CACHE_ENABLED, UploadImpl.class,
						upload.getPrimaryKey()) == null) {
				cacheResult(upload);
			}
			else {
				upload.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all uploads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UploadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UploadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the upload.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Upload upload) {
		EntityCacheUtil.removeResult(UploadModelImpl.ENTITY_CACHE_ENABLED,
			UploadImpl.class, upload.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Upload> uploads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Upload upload : uploads) {
			EntityCacheUtil.removeResult(UploadModelImpl.ENTITY_CACHE_ENABLED,
				UploadImpl.class, upload.getPrimaryKey());
		}
	}

	/**
	 * Creates a new upload with the primary key. Does not add the upload to the database.
	 *
	 * @param uploadId the primary key for the new upload
	 * @return the new upload
	 */
	@Override
	public Upload create(long uploadId) {
		Upload upload = new UploadImpl();

		upload.setNew(true);
		upload.setPrimaryKey(uploadId);

		return upload;
	}

	/**
	 * Removes the upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uploadId the primary key of the upload
	 * @return the upload that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchUploadException if a upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload remove(long uploadId)
		throws NoSuchUploadException, SystemException {
		return remove((Serializable)uploadId);
	}

	/**
	 * Removes the upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the upload
	 * @return the upload that was removed
	 * @throws de.uhh.l2g.plugins.NoSuchUploadException if a upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload remove(Serializable primaryKey)
		throws NoSuchUploadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Upload upload = (Upload)session.get(UploadImpl.class, primaryKey);

			if (upload == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(upload);
		}
		catch (NoSuchUploadException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Upload removeImpl(Upload upload) throws SystemException {
		upload = toUnwrappedModel(upload);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(upload)) {
				upload = (Upload)session.get(UploadImpl.class,
						upload.getPrimaryKeyObj());
			}

			if (upload != null) {
				session.delete(upload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (upload != null) {
			clearCache(upload);
		}

		return upload;
	}

	@Override
	public Upload updateImpl(de.uhh.l2g.plugins.model.Upload upload)
		throws SystemException {
		upload = toUnwrappedModel(upload);

		boolean isNew = upload.isNew();

		UploadModelImpl uploadModelImpl = (UploadModelImpl)upload;

		Session session = null;

		try {
			session = openSession();

			if (upload.isNew()) {
				session.save(upload);

				upload.setNew(false);
			}
			else {
				session.merge(upload);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UploadModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((uploadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						uploadModelImpl.getOriginalVideoId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { uploadModelImpl.getVideoId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}
		}

		EntityCacheUtil.putResult(UploadModelImpl.ENTITY_CACHE_ENABLED,
			UploadImpl.class, upload.getPrimaryKey(), upload);

		return upload;
	}

	protected Upload toUnwrappedModel(Upload upload) {
		if (upload instanceof UploadImpl) {
			return upload;
		}

		UploadImpl uploadImpl = new UploadImpl();

		uploadImpl.setNew(upload.isNew());
		uploadImpl.setPrimaryKey(upload.getPrimaryKey());

		uploadImpl.setUploadId(upload.getUploadId());
		uploadImpl.setUserId(upload.getUserId());
		uploadImpl.setContentLength(upload.getContentLength());
		uploadImpl.setTimestamp(upload.getTimestamp());
		uploadImpl.setStatus(upload.getStatus());
		uploadImpl.setVideoId(upload.getVideoId());

		return uploadImpl;
	}

	/**
	 * Returns the upload with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the upload
	 * @return the upload
	 * @throws de.uhh.l2g.plugins.NoSuchUploadException if a upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUploadException, SystemException {
		Upload upload = fetchByPrimaryKey(primaryKey);

		if (upload == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUploadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return upload;
	}

	/**
	 * Returns the upload with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchUploadException} if it could not be found.
	 *
	 * @param uploadId the primary key of the upload
	 * @return the upload
	 * @throws de.uhh.l2g.plugins.NoSuchUploadException if a upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload findByPrimaryKey(long uploadId)
		throws NoSuchUploadException, SystemException {
		return findByPrimaryKey((Serializable)uploadId);
	}

	/**
	 * Returns the upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the upload
	 * @return the upload, or <code>null</code> if a upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Upload upload = (Upload)EntityCacheUtil.getResult(UploadModelImpl.ENTITY_CACHE_ENABLED,
				UploadImpl.class, primaryKey);

		if (upload == _nullUpload) {
			return null;
		}

		if (upload == null) {
			Session session = null;

			try {
				session = openSession();

				upload = (Upload)session.get(UploadImpl.class, primaryKey);

				if (upload != null) {
					cacheResult(upload);
				}
				else {
					EntityCacheUtil.putResult(UploadModelImpl.ENTITY_CACHE_ENABLED,
						UploadImpl.class, primaryKey, _nullUpload);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UploadModelImpl.ENTITY_CACHE_ENABLED,
					UploadImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return upload;
	}

	/**
	 * Returns the upload with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uploadId the primary key of the upload
	 * @return the upload, or <code>null</code> if a upload with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Upload fetchByPrimaryKey(long uploadId) throws SystemException {
		return fetchByPrimaryKey((Serializable)uploadId);
	}

	/**
	 * Returns all the uploads.
	 *
	 * @return the uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Upload> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.UploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of uploads
	 * @param end the upper bound of the range of uploads (not inclusive)
	 * @return the range of uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Upload> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.UploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of uploads
	 * @param end the upper bound of the range of uploads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Upload> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Upload> list = (List<Upload>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UPLOAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UPLOAD;

				if (pagination) {
					sql = sql.concat(UploadModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Upload>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Upload>(list);
				}
				else {
					list = (List<Upload>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the uploads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Upload upload : findAll()) {
			remove(upload);
		}
	}

	/**
	 * Returns the number of uploads.
	 *
	 * @return the number of uploads
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_UPLOAD);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the upload persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.de.uhh.l2g.plugins.model.Upload")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Upload>> listenersList = new ArrayList<ModelListener<Upload>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Upload>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(UploadImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UPLOAD = "SELECT upload FROM Upload upload";
	private static final String _SQL_SELECT_UPLOAD_WHERE = "SELECT upload FROM Upload upload WHERE ";
	private static final String _SQL_COUNT_UPLOAD = "SELECT COUNT(upload) FROM Upload upload";
	private static final String _SQL_COUNT_UPLOAD_WHERE = "SELECT COUNT(upload) FROM Upload upload WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "upload.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Upload exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Upload exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UploadPersistenceImpl.class);
	private static Upload _nullUpload = new UploadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Upload> toCacheModel() {
				return _nullUploadCacheModel;
			}
		};

	private static CacheModel<Upload> _nullUploadCacheModel = new CacheModel<Upload>() {
			@Override
			public Upload toEntityModel() {
				return _nullUpload;
			}
		};
}