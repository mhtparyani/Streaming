package com.shera.internexttv.model;

public class LiveChannelDTO {

    private Long num;
    private String name;
    private String stream_type;
    private String stream_icon;
    private String added;
    private String category_id;
    private String custom_sid;
    private String direct_source;
    private Long stream_id;
    private String epg_channel_id;
    private Long tv_archive;
    private Long tv_archive_duration;

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStream_type() {
        return stream_type;
    }

    public void setStream_type(String stream_type) {
        this.stream_type = stream_type;
    }

    public String getStream_icon() {
        return stream_icon;
    }

    public void setStream_icon(String stream_icon) {
        this.stream_icon = stream_icon;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCustom_sid() {
        return custom_sid;
    }

    public void setCustom_sid(String custom_sid) {
        this.custom_sid = custom_sid;
    }

    public String getDirect_source() {
        return direct_source;
    }

    public void setDirect_source(String direct_source) {
        this.direct_source = direct_source;
    }

    public Long getStream_id() {
        return stream_id;
    }

    public void setStream_id(Long stream_id) {
        this.stream_id = stream_id;
    }

    public String getEpg_channel_id() {
        return epg_channel_id;
    }

    public void setEpg_channel_id(String epg_channel_id) {
        this.epg_channel_id = epg_channel_id;
    }

    public Long getTv_archive() {
        return tv_archive;
    }

    public void setTv_archive(Long tv_archive) {
        this.tv_archive = tv_archive;
    }

    public Long getTv_archive_duration() {
        return tv_archive_duration;
    }

    public void setTv_archive_duration(Long tv_archive_duration) {
        this.tv_archive_duration = tv_archive_duration;
    }
}
