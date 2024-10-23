/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.26).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.identiproof.verifier.api;

import io.identiproof.verifier.model.ServerResponse;
import io.identiproof.verifier.model.ValidateRequest;
import io.identiproof.verifier.model.ValidateResponse;
import io.identiproof.verifier.model.VerifyVpRequest;
import io.identiproof.verifier.model.W3cVcSkelsList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-30T19:57:55.440700+01:00[Europe/London]")
@Validated
public interface V1Api {

    @Operation(summary = "Validate Policy Matching", description = "Valicate Policy Matching for a set of VCs", tags={ "Access Decision" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Validate Response Object", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValidateResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "A request parameter is missing or badly formed.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServerResponse.class))),
        
        @ApiResponse(responseCode = "404", description = "The policy cannot be found in the policy registry.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServerResponse.class))),
        
        @ApiResponse(responseCode = "406", description = "The policy format is not acceptable.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServerResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "Something went wrong with the Policy Matcher e.g. database error or other bug.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServerResponse.class))),
        
        @ApiResponse(responseCode = "503", description = "The Policy Registry is currently not available.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServerResponse.class))) })
    @RequestMapping(value = "/v1/validate",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ValidateResponse> validate(@Parameter(in = ParameterIn.DEFAULT, description = "Policy Match, Policy Registry URL, set of VCs", required=true, schema=@Schema()) @Valid @RequestBody ValidateRequest body);


    @Operation(summary = "Verify if VP is legitim and valid", description = "Verify if a VP is legitim and valid", tags={ "VP Verification" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Request Access Decision Response Object", content = @Content(mediaType = "application/json", schema = @Schema(implementation = W3cVcSkelsList.class))),
        
        @ApiResponse(responseCode = "400", description = "The VP or an embedded VC is badly formatted or the cryptography failed.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServerResponse.class))),
        
        @ApiResponse(responseCode = "401", description = "VC not issued to VC Holder or VCs not all issued to VC holder or VC delegation problem or mismatch between VP and embedded VCs.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServerResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "Something went wrong with the Verifier", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ServerResponse.class))) })
    @RequestMapping(value = "/v1/verify",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<W3cVcSkelsList> verifyVp(@Parameter(in = ParameterIn.DEFAULT, description = "Verifiable Presentation, RP URL, and Challenge", required=true, schema=@Schema()) @Valid @RequestBody VerifyVpRequest body);

}
