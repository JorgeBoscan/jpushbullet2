package net.iharder.jpushbullet2.pushes;

import com.google.gson.annotations.Expose;

public class LinkPush implements SendPush {

    @Expose
    private final String device_iden;
    @Expose
    private final String email;
    @Expose
    private final String type = "link";
    @Expose
    private final String title;
    @Expose
    private final String body;
    @Expose
    private final String url;

    private LinkPush(LinkPushBuilder builder) {
        this.device_iden = builder.device_iden;
        this.email = builder.email;
        this.title = builder.title;
        this.body = builder.body;
        this.url = builder.url;
    }

    public String getDevice_iden() {
        return device_iden;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getUrl() {
        return url;
    }

    public static class LinkPushBuilder {
        private String device_iden;
        private String email;
        private String title;
        private String body;
        private String url;

        public LinkPushBuilder url(final String url) {
            this.url = url;
            return this;
        }

        public LinkPushBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public LinkPushBuilder body(final String body) {
            this.body = body;
            return this;
        }

        public LinkPushBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public LinkPushBuilder deviceIden(final String deviceIden) {
            this.device_iden = deviceIden;
            return this;
        }

        public SendPush create() {
            return new LinkPush(this);
        }
    }
}
