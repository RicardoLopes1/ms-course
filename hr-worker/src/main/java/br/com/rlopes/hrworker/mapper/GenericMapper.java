package br.com.rlopes.hrworker.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class GenericMapper {

    private final ModelMapper modelMapper;

    public <T> T map(Object source, Class<T> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public <T> List<T> mapList(List<?> sourceList, Class<T> destinationType) {
        return sourceList.stream()
                .map(element -> this.map(element, destinationType))
                .collect(Collectors.toList());
    }
}
