package net.iharder.jpushbullet2.pushes;

import com.google.gson.annotations.Expose;

public class NotePush implements SendPush {
    @Expose
    private final String device_iden;
    @Expose
    private final String email;
    @Expose
    private final String title;
    @Expose
    private final String body;
    @Expose
    private final String type = "note";

    private NotePush(NotePushBuilder buider) {
        this.device_iden = buider.device_iden;
        this.email = buider.email;
        this.title = buider.title;
        this.body = buider.body;
    }

    public String getDevice_iden() {
        return device_iden;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getType() {
        return type;
    }

    public static class NotePushBuilder {
        private String device_iden;
        private String email;
        private String title;
        private String body;

        public NotePushBuilder() {}

        public NotePushBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public NotePushBuilder deviceIden(final String deviceIden) {
            this.device_iden = deviceIden;
            return this;
        }

        public NotePushBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public NotePushBuilder body(final String body) {
            this.body = body;
            return this;
        }

        public NotePush create() {
            return new NotePush(this);
        }
    }
}
