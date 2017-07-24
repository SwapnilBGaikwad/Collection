package com.datastructures;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Contact {
    abstract String name();

    abstract String mobile();

    static Builder builder() {
        return new AutoValue_Contact.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder setName(String name);

        abstract Builder setMobile(String mobile);

        abstract Contact build();
    }

}
