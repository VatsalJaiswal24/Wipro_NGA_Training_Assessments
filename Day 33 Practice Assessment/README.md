# MetroRide API - Day 33 Assessment
## Cloud Deployment + Kubernetes + Auto Scale + KEDA + Code Quality + Deployment Strategies

This repository contains all the required configuration files for the Day 33 Daily Assessment.

---

## 📁 Project Structure

```
Day 33 Practice Assessment/
├── sonar-project.properties      # Task 1: SonarQube configuration
├── k8s/
│   ├── deployment.yaml           # Task 2: Kubernetes Deployment (3 replicas)
│   ├── service.yaml              # Task 2: NodePort Service
│   ├── hpa.yaml                  # Task 3: Horizontal Pod Autoscaler (50% CPU)
│   ├── keda-scaledobject.yaml    # Task 4: KEDA event-driven scaling
│   ├── rolling-update-deployment.yaml    # Task 5: Rolling Update Strategy
│   ├── blue-green-blue-deployment.yaml   # Task 5: Blue deployment
│   ├── blue-green-green-deployment.yaml  # Task 5: Green deployment
│   └── blue-green-service.yaml           # Task 5: Blue/Green service
└── README.md
```

---

## ⚙️ Task 1: SonarQube Code Quality (7 Marks)

### Start SonarQube Server (Docker)
```bash
docker run -d --name sonarqube -p 9000:9000 sonarqube:latest
```

### Run Analysis
```bash
sonar-scanner -Dsonar.projectKey=metro -Dsonar.sources=src
```

### View Dashboard
Open: http://localhost:9000/dashboard?id=metro

---

## 🚀 Task 2: Kubernetes Deployment (10 Marks)

### Apply Configurations
```bash
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```

### Verify Deployment
```bash
kubectl get pods
kubectl get svc
kubectl get deployment metroride-api
```

---

## 📈 Task 3: Autoscaling with HPA (7 Marks)

### Prerequisites
```bash
# Install Metrics Server (required for HPA)
kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
```

### Apply HPA
```bash
kubectl apply -f k8s/hpa.yaml
```

### Verify HPA
```bash
kubectl get hpa
kubectl describe hpa metroride-api-hpa
```

---

## ⚡ Task 4: KEDA Event-Based Scaling (8 Marks)

### Install KEDA
```bash
# Using Helm
helm repo add kedacore https://kedacore.github.io/charts
helm repo update
helm install keda kedacore/keda --namespace keda --create-namespace

# OR using kubectl
kubectl apply -f https://github.com/kedacore/keda/releases/download/v2.12.0/keda-2.12.0.yaml
```

### Apply ScaledObject
```bash
kubectl apply -f k8s/keda-scaledobject.yaml
```

### Verify KEDA
```bash
kubectl get scaledobject
kubectl describe scaledobject metroride-api-scaledobject
```

---

## 🔄 Task 5: Deployment Strategies (8 Marks)

### Rolling Update Strategy
```bash
kubectl apply -f k8s/rolling-update-deployment.yaml
kubectl rollout status deployment/metroride-api-rolling
```

**Key Features:**
- `maxSurge: 1` - One extra pod during update
- `maxUnavailable: 0` - Zero downtime guarantee

### Blue/Green Strategy
```bash
# Deploy both versions
kubectl apply -f k8s/blue-green-blue-deployment.yaml
kubectl apply -f k8s/blue-green-green-deployment.yaml
kubectl apply -f k8s/blue-green-service.yaml

# Switch to Green
kubectl patch svc metroride-api-bluegreen-service -p '{"spec":{"selector":{"version":"green"}}}'

# Rollback to Blue
kubectl patch svc metroride-api-bluegreen-service -p '{"spec":{"selector":{"version":"blue"}}}'
```

---

## 📊 Quick Reference: Verification Commands

| Task | Command |
|------|---------|
| Get Pods | `kubectl get pods` |
| Get Services | `kubectl get svc` |
| Get HPA | `kubectl get hpa` |
| Get ScaledObject | `kubectl get scaledobject` |
| Describe Deployment | `kubectl describe deployment metroride-api` |

---

## 🛠️ Prerequisites

- Docker Desktop with Kubernetes enabled OR Minikube
- kubectl CLI installed
- Helm (for KEDA installation)
- Java 17+ and Maven (for building the application)
- SonarQube Scanner (for code analysis)

## Author
Vatsal Jaiswal
