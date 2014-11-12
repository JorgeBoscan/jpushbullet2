package net.iharder.jpushbullet2.pushes;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ListPush implements SendPush {

    @Expose
    private final String device_iden;
    @Expose
    private final String email;
    @Expose
    private final String type = "list";
    @Expose
    private final String title;
    @Expose
    private final List<String> items;

    public ListPush(ListPushBuilder builder) {
        this.device_iden = builder.device_iden;
        this.email = builder.email;
        this.title = builder.title;
        this.items = builder.items;
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

    public List<String> getItems() {
        return items;
    }

    public static class ListPushBuilder {
        private String device_iden;
        private String email;
        private String title;
        private List<String> items = new ArrayList<String>();

        public ListPushBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public ListPushBuilder item(final String item) {
            items.add(item);
            return this;
        }

        public ListPushBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public ListPushBuilder deviceIden(final String deviceIden) {
            this.device_iden = deviceIden;
            return this;
        }

        public SendPush create() {
            return new ListPush(this);
        }
    }
}
