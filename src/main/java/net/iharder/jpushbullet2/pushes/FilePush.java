package net.iharder.jpushbullet2.pushes;

import com.google.gson.annotations.Expose;

import java.io.File;

public class FilePush implements SendPush {

    @Expose
    private final String device_iden;
    @Expose
    private final String email;
    @Expose
    private final String type = "file";
    @Expose
    private final String file_name;
    @Expose
    private final String file_type;
    @Expose
    private final String file_url;
    @Expose
    private final String body;
    private final File file;

    public File getFile() {
        return file;
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

    public String getFile_name() {
        return file_name;
    }

    public String getFile_type() {
        return file_type;
    }

    public String getFile_url() {
        return file_url;
    }

    public String getBody() {
        return body;
    }

    private FilePush(FilePushBuilder builder) {
        this.device_iden = builder.device_iden;
        this.email = builder.email;
        this.body = builder.body;
        this.file = builder.file;
        this.file_name = builder.file_name;
        this.file_type = builder.file_type;
        this.file_url = builder.file_url;
    }

    public static class FilePushBuilder {
        private String device_iden;
        private String email;
        private String body;
        private String file_name;
        private String file_type;
        private String file_url;
        private File file;

        public FilePushBuilder fileName(final String fileName) {
            this.file_name = fileName;
            return this;
        }

        public FilePushBuilder fileType(final String fileType) {
            this.file_type = fileType;
            return this;
        }

        public FilePushBuilder fileUrl(final String fileUrl) {
            this.file_url = fileUrl;
            return this;
        }

        public FilePushBuilder file(final File file) {
            this.file = file;
            return this;
        }

        public FilePushBuilder body(final String body) {
            this.body = body;
            return this;
        }

        public FilePushBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public FilePushBuilder deviceIden(final String deviceIden) {
            this.device_iden = deviceIden;
            return this;
        }

        public SendPush create() {
            return new FilePush(this);
        }
    }
}
