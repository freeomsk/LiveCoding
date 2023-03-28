package ru.freeomsk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganizationWrapper {

    public static class OrganizationEntity {

        public Long id;
        public Long parentId;
        public String name;
    }

    public static class OrganizationDto {

        public Long id;

        public String name;
        public List<OrganizationDto> childs;
    }
    public List<OrganizationDto> mapper(List<OrganizationEntity> entities) {
        // создаем map для хранения DTO-объектов по их идентификаторам
        Map<Long, OrganizationDto> organizationDtoMap = new HashMap<>();

        // проходим по списку объектов OrganizationEntity и создаем соответствующие DTO-объекты
        for (OrganizationEntity entity : entities) {
            OrganizationDto organizationDto = new OrganizationDto();
            organizationDto.id = entity.id;
            organizationDto.name = entity.name;
            organizationDto.childs = new ArrayList<>();

            // добавляем DTO-объект в map
            organizationDtoMap.put(entity.id, organizationDto);
        }

        // связываем каждый DTO с его родительским DTO
        // если у объекта OrganizationEntity есть родитель, находим соответствующий DTO-объект и добавляем его в список его дочерних элементов
        for (OrganizationEntity entity : entities) {
            OrganizationDto orgDto = organizationDtoMap.get(entity.id);
            if (entity.parentId != null) {
                OrganizationDto parentDto = organizationDtoMap.get(entity.parentId);
                parentDto.childs.add(orgDto);
            }
        }

        // находим всех потомков OrganizationEntity по id родителя и помещаем в DTO (без родителя).
        return entities.stream()
                .filter(entity -> entity.parentId == null)
                .map(entity -> organizationDtoMap.get(entity.parentId))
                .collect(Collectors.toList());
    }
}