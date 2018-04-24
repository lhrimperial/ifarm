package com.ifarm.console.shared.domain.vo;

import com.ifarm.console.shared.domain.dto.ResourceDTO;

import java.util.List;

/**
 *
 */
public class ResourceVO extends BaseVO {

    private ResourceDTO resourceDTO;
    private List<ResourceDTO> resourceDTOS;

    public ResourceDTO getResourceDTO() {
        return resourceDTO;
    }

    public void setResourceDTO(ResourceDTO resourceDTO) {
        this.resourceDTO = resourceDTO;
    }

    public List<ResourceDTO> getResourceDTOS() {
        return resourceDTOS;
    }

    public void setResourceDTOS(List<ResourceDTO> resourceDTOS) {
        this.resourceDTOS = resourceDTOS;
    }
}
