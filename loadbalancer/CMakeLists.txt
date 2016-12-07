cmake_minimum_required(VERSION 3.5)
project(loadbalancer-proy)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp)
add_executable(loadbalancer ${SOURCE_FILES})

file(REMOVE_RECURSE [../release/loadbalancer-daemon.sh ../release/mosquitto])

INSTALL(FILES loadbalancer-daemon.sh
        DESTINATION ../release) 

INSTALL(FILES mosquitto/*
        DESTINATION ../release/mosquitto) 


add_custom_command(TARGET loadbalancer 
                   POST_BUILD
                   COMMAND ${CMAKE_COMMAND} -E copy $<TARGET_FILE:loadbalancer> ../release)
