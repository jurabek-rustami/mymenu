package mimsoft.io.lemenu.extra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ExtraController {

    private final ExtraService extraService;

    public ExtraController(ExtraService extraService) {
        this.extraService = extraService;
    }

    @GetMapping("/extras")
    public ResponseEntity<List<ExtraDto>> getAll() {
        return ResponseEntity.ok(extraService.getAll());
    }

    @GetMapping("/extra/{id}")
    public ResponseEntity<Extra> get(@PathVariable Long id) {
        Optional<Extra> extra = extraService.findById(id);
        return extra.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PostMapping("/extra")
    public ResponseEntity<Void> add(@RequestBody ExtraDto extraDto) {
        extraService.save(extraDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/extra/{id}")
    public ResponseEntity<Void> update(@RequestBody ExtraDto extraDto, @PathVariable Long id) {
        extraService.update(extraDto, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/extra")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        extraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
