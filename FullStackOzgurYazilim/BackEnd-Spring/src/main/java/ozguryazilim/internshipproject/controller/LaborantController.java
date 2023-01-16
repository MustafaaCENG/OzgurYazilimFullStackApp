package ozguryazilim.internshipproject.controller;


import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ozguryazilim.internshipproject.dto.LaborantDto;
import ozguryazilim.internshipproject.service.impl.LaborantServiceImpl;
import ozguryazilim.internshipproject.util.ApiPaths;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(ApiPaths.LaborantCtrl.CTRL)
public class LaborantController {

    @Autowired
    private LaborantServiceImpl laborantServiceimpl;


     @Operation(summary = "Get All Operation")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200",description = "Succesful Operation",content = @Content(schema = @Schema(implementation = LaborantDto.class))),
             @ApiResponse(responseCode = "404", description = "laborant not found")
     })
    @GetMapping()
    public ResponseEntity<List<LaborantDto>> getAll() {
        List<LaborantDto> data = laborantServiceimpl.getAll();
        return ResponseEntity.ok(data);
    }


     @Operation(summary = "Get By Id Operation")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200",description = "Succesful Operation",content = @Content(schema = @Schema(implementation = LaborantDto.class))),
             @ApiResponse(responseCode = "404", description = "laborant not found")
     })
    @GetMapping("/{laborantid}")
     public ResponseEntity<LaborantDto> getById(@PathVariable(value = "laborantid", required = true) Long laborantid) {
         LaborantDto laborantDto = laborantServiceimpl.getById(laborantid);
         if (laborantDto == null) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
         }
         return ResponseEntity.ok(laborantDto);
     }

       @Operation(summary = "Create Operation")
       @ApiResponses(value = {
               @ApiResponse(responseCode = "201",description = "Succesfull Operation",content = @Content(schema = @Schema(implementation = LaborantDto.class))),
               @ApiResponse(responseCode = "409", description = "laborant could not be created")
       })
    @PostMapping
    public ResponseEntity<LaborantDto> createLaborant(@Valid @RequestBody LaborantDto laborantDto) {

        try {
            LaborantDto newLaborant = laborantServiceimpl.save(laborantDto);

            return ResponseEntity.created(new URI(ApiPaths.ReportCtrl.CTRL + "/" + newLaborant.getId())).body(newLaborant);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


    // @PutMapping("/{laborantid}")
    // @Operation(summary = "Update Operation")
    // @ApiResponses(value = {
    //         @ApiResponse(responseCode = "204",description = "Succesfull Operation",content = @Content(schema = @Schema(implementation = LaborantDto.class))),
    //         @ApiResponse(responseCode = "404", description = "laborant not found ")
    // })
    //public ResponseEntity<LaborantDto> updateLaborant(@PathVariable(value = "laborantid", required = true) Long laborantid,
    //                                                 @Valid @RequestBody LaborantDto laborantDto) {
    //    try {
    //        laborantServiceimpl.update(laborantid, laborantDto);
    //        return ResponseEntity.noContent().build();
    //    } catch (Exception e) {
    //        return ResponseEntity.notFound().build();
    //    }
    //}


    //  @Operation(summary = "Delete Operation")
    //  @ApiResponses(value = {
    //          @ApiResponse(responseCode = "204",description = "Succesfull Operation",content = @Content(schema = @Schema(implementation = Boolean.class))),
    //          @ApiResponse(responseCode = "400", description = "Id connot be null"),
    //          @ApiResponse(responseCode = "404", description = "An error occured")
    //  })
    // @DeleteMapping("/{laborantid}")
    // public ResponseEntity<Boolean> delete(@PathVariable(value = "laborantid", required = true) Long laborantid) {
    //     try {
    //         if (laborantid != null) {
    //             Boolean isDeleted = laborantServiceimpl.delete(laborantid);
    //             return ResponseEntity.ok(isDeleted);
    //         } else {
    //             return ResponseEntity.badRequest().build();
    //         }
    //     } catch (Exception e) {
    //         return ResponseEntity.notFound().build();
    //     }

    // }
}

