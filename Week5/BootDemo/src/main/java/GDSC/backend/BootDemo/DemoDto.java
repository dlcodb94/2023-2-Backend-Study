package GDSC.backend.BootDemo;

import lombok.Getter;

/** DemoDto.java **/

@Getter
public class DemoDto {
    private Long id;
    private String name;

    public DemoDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}