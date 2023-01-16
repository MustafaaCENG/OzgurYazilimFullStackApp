package ozguryazilim.internshipproject.controller;

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
import ozguryazilim.internshipproject.dto.ReportDto;
import ozguryazilim.internshipproject.service.impl.ReportServiceImpl;
import ozguryazilim.internshipproject.util.ApiPaths;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(ApiPaths.ReportCtrl.CTRL)
public class ReportController {


    @Autowired
    private ReportServiceImpl reportServiceImpl;


      @Operation(summary = "Get All Operation")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200", description = "Successful Operation",
                     content = @Content(array = @ArraySchema(schema = @Schema(implementation = ReportDto.class)))
             )})
    @GetMapping()
    public ResponseEntity<List<ReportDto>> getAll() {
        List<ReportDto> data = reportServiceImpl.getAll();
        return ResponseEntity.ok(data);
    }


     @Operation(summary = "Get By Id Operation")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200",description = "Succesful Operation",content = @Content(schema = @Schema(implementation = ReportDto.class))),
             @ApiResponse(responseCode = "404", description = "Report not found")
     })
    @GetMapping("/{reportid}")
    public ResponseEntity<ReportDto> getById(@PathVariable(value = "reportid", required = true) Long reportid) {
        try {
            ReportDto reportDto = reportServiceImpl.getById(reportid);
            return ResponseEntity.ok(reportDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); //return 404, with null body
        }
    }

     @Operation(summary = "Get By Search")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "200",description = "Succesful Operation",content = @Content(schema = @Schema(implementation = ReportDto.class))),
             @ApiResponse(responseCode = "404", description = "Empty Result")
     })
    @GetMapping("search/{value}")
    public ResponseEntity<List<ReportDto>> getSearch(@PathVariable(value = "value",required = true) String value){
        try{
            List<ReportDto> data = reportServiceImpl.getBySearch(value);
            return ResponseEntity.ok(data);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("queryDate")  // @PathVariable(value = "queryDate",required = true) String queryDate
    public ResponseEntity<List<ReportDto>> getQueryDate(){
        try{
            List<ReportDto> data = reportServiceImpl.getByDateQuery();
            return ResponseEntity.ok(data);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    @Operation(summary = "Create Operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Succesfull Operation",content = @Content(schema = @Schema(implementation = ReportDto.class))),
            @ApiResponse(responseCode = "409", description = "Report could not be created")
    })
    @PostMapping
    public ResponseEntity<ReportDto> createReport(@Valid @RequestBody ReportDto reportDto) {

        try {
            ReportDto newProject = reportServiceImpl.create(reportDto);
            return ResponseEntity.created(new URI(ApiPaths.ReportCtrl.CTRL + "/" + newProject.getId())).body(newProject);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }



     @Operation(summary = "Update Operation")
     @ApiResponses(value = {
             @ApiResponse(responseCode = "204",description = "Succesfull Operation",content = @Content(schema = @Schema(implementation = ReportDto.class))),
             @ApiResponse(responseCode = "404", description = "Project not found ")
     })
    @PutMapping("/{reportid}")
    public ResponseEntity<ReportDto> updateProject(@PathVariable(value = "reportid", required = true) Long reportid,
                                                   @Valid @RequestBody ReportDto reportDto) {
        try {
            reportServiceImpl.update(reportid, reportDto);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping("/{reportid}")
    @Operation(summary = "Delete Operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "Succesfull Operation",content = @Content(schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "400", description = "Id connot be null"),
            @ApiResponse(responseCode = "404", description = "An error occured")
    })
    public ResponseEntity<Boolean> delete(@PathVariable(value = "reportid", required = true) Long reportid) {
        try {
            if (reportid != null) {

                Boolean isDeleted = reportServiceImpl.delete(reportid);
                return ResponseEntity.ok(isDeleted);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
