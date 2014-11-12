package net.iharder.jpushbullet2.pushes;

import com.google.gson.annotations.Expose;

public class AddressPush implements SendPush {
    @Expose
    private final String device_iden;
    @Expose
    private final String email;
    @Expose
    private final String type = "address";
    @Expose
    private final String name;
    @Expose
    private final String address;

    public AddressPush(AddressPushBuilder builder) {
        this.device_iden = builder.device_iden;
        this.email = builder.email;
        this.name = builder.name;
        this.address = builder.address;
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

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static class AddressPushBuilder {
        private String device_iden;
        private String email;
        private String name;
        private String address;

        public AddressPushBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public AddressPushBuilder address(final String address) {
            this.address = address;
            return this;
        }

        public AddressPushBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public AddressPushBuilder deviceIden(final String deviceIden) {
            this.device_iden = deviceIden;
            return this;
        }

        public SendPush create() {
            return new AddressPush(this);
        }
    }
}
