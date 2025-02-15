package com.previred.users_app.infrastructure.docs;

import com.previred.users_app.infrastructure.dto.CreateUserRequestDto;
import com.previred.users_app.infrastructure.dto.UpdateUserRequestDto;
import com.previred.users_app.infrastructure.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Tag(name = "Usuarios", description = "CRUD de usuarios")
public interface UserControllerDocs {

    @PostMapping
    @Operation(summary = "Crear un usuario", description = "Registra un nuevo usuario en el sistema.")
    @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente",
            content = @Content(schema = @Schema(implementation = UserResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody CreateUserRequestDto requestDto);

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un usuario por ID", description = "Busca un usuario por su UUID.")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado",
            content = @Content(schema = @Schema(implementation = UserResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "ID no válido")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    ResponseEntity<UserResponseDto> findUserById(@PathVariable("id") String id);

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve la lista de todos los usuarios registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios",
            content = @Content(schema = @Schema(implementation = UserResponseDto.class)))
    @ApiResponse(responseCode = "204", description = "No hay usuarios registrados")
    ResponseEntity<List<UserResponseDto>> getAllUsers();

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario", description = "Modifica los datos de un usuario existente.")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado",
            content = @Content(schema = @Schema(implementation = UserResponseDto.class)))
    @ApiResponse(responseCode = "400", description = "ID no válido")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") String id, @Valid @RequestBody UpdateUserRequestDto requestDto);

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario por su ID.")
    @ApiResponse(responseCode = "204", description = "Usuario eliminado")
    @ApiResponse(responseCode = "400", description = "ID no válido")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    ResponseEntity<Void> deleteUser(@PathVariable("id") String id);
}
