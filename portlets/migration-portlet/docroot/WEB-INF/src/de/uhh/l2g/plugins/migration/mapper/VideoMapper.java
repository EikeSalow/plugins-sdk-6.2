package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyVideo;
import de.uhh.l2g.plugins.model.Video;

public class VideoMapper {
	static final Log log = LogFactoryUtil.getLog(VideoMapper.class);; 
	
	public static Video mapVideo(LegacyVideo legacyVideo, Video video, long companyId) {
		if (video == null || legacyVideo == null) {
			log.warn("can't execute method with null values - return video as null value");
			return null;
		}
		
		video.setCitation2go(legacyVideo.getCitation2go());
		video.setContainerFormat(legacyVideo.getContainerFormat());;
		video.setDownloadLink(legacyVideo.getDownloadLink());
		video.setDuration(legacyVideo.getDuration());
		video.setFilename(legacyVideo.getFilename());
		video.setFileSize(legacyVideo.getFileSize());
		video.setGenerationDate(legacyVideo.getGenerationDate());
		video.setHits(legacyVideo.getHits());
		video.setHostId(legacyVideo.getHostId());
		video.setLectureseriesId(legacyVideo.getLectureseriesId());
		video.setMetadataId(legacyVideo.getMetadataId());
		video.setOpenAccess(legacyVideo.getOpenAccess());
		video.setPermittedToSegment(legacyVideo.getPermittedToSegment());
		video.setProducerId(UserIDMapper.getNewUserId(legacyVideo.getProducerId(), companyId));
		video.setResolution(legacyVideo.getResolution());
		// TODO sourcedata comes from ?
		// video.setRootInstitutionId(legacyVideo.get);
		video.setSurl(legacyVideo.getSurl());
		video.setTags(legacyVideo.getTags());
		// TODO sourcedata comes from ?
		//video.setTermId(legacyVideo);
		video.setTitle(legacyVideo.getTitle());
		video.setUploadDate(legacyVideo.getUploadDate());
		// TODO sourcedata comes from ?
		//video.setVideoCreatorId(legacyVideo.getVideoCreatorId());
		return video;
	} 


}
