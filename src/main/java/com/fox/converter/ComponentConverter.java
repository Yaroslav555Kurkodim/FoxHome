package com.fox.converter;

import com.fox.entity.Component;
import com.fox.model.ComponentModel;
import com.fox.model.request.ComponentModelRequest;

public interface ComponentConverter {
    Component convertComponentRequestToComponent(ComponentModelRequest componentRequest);

    ComponentModel convertComponentToComponentModel(Component component);
}
