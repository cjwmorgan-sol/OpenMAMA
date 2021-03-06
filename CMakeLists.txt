cmake_minimum_required (VERSION 2.8)
project (OpenmMAMA)

message(WARNING "The CMake build system for OpenMAMA is experimental. See https://openmama.github.io/openmama_build_instructions.html for officially supported build instructions.")

list(APPEND CMAKE_MODULE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/cmake)
include(${CMAKE_C_COMPILER_ID})

# Build type options
set (WITH_EXAMPLES   true   CACHE BOOL   "Include compiled example applications in the build (e.g. mamalistenc)")
set (WITH_TESTTOOLS  true   CACHE BOOL   "Include test tools in the build (e.g. capturereplay)")
set (WITH_UNITTEST   false  CACHE BOOL   "Include unit tests in the build (e.g. UnitTestMamaC)")
set (WITH_PROTON     true   CACHE BOOL   "Include the qpid proton middleware and payload bridges in the build")
set (WITH_MAMDA      true   CACHE BOOL   "Include MAMDA in the build")
set (WITH_JAVA       false  CACHE BOOL   "Include JAVA bindings")
set (WITH_CPP        true   CACHE BOOL   "Include C++ bindings")
set (ENTITLEMENTS    "noop" CACHE STRING "Comma delimited list of entitlement bridges to allow to load at runtime")

if (WIN32 AND MSVC)
    set (WITH_CSHARP false CACHE BOOL "Include examples during the build")
endif()

# Dependency detection options
set (LIBEVENT_ROOT "${DEFAULT_LIBEVENT_ROOT}" CACHE PATH "Libevent dependency install directory (for qpid)")
set (PROTON_ROOT   "${DEFAULT_PROTON_ROOT}"   CACHE PATH "Qpid dependency install directory (for qpid middleware and payload bridges)")
set (APR_ROOT      "${DEFAULT_APR_ROOT}"      CACHE PATH "Apache APR dependency install directory (for core MAMA)")
set (GTEST_ROOT    "${DEFAULT_GTEST_ROOT}"    CACHE PATH "Google test framework dependency install directory (for unit tests)")
set (OEA_ROOT      "${DEFAULT_OEA_ROOT}"      CACHE PATH "OEA dependency install directory (for ef ENTITLEMENTS is set to oea)")

# Install / post-compilation options
set (INSTALL_RUNTIME_DEPENDENCIES true CACHE BOOL "Whether or not to include dependent .so or .dll files in the installation package")

add_subdirectory (common)
add_subdirectory (mama)

if (WITH_MAMDA AND WITH_CPP)
   add_subdirectory (mamda)
endif()
