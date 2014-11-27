#!/bin/bash
mkdir -p ../java/fst/proto
protoc --java_out=../java test.proto