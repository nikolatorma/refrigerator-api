#!/bin/bash

echo "🔨 Building JAR with Maven..."
./mvnw clean package -DskipTests

if [ $? -eq 0 ]; then
  echo "✅ Build successful — starting Docker Compose..."
  docker compose up --build
else
  echo "❌ Maven build failed — aborting Docker Compose."
fi
