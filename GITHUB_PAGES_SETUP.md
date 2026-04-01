# 📤 GitHub Pages Setup Guide

## Option 1: Deploy to GitHub Pages (Frontend Demo)

### Step 1: Prepare Your Repository

Your repository should have this structure:
```
Projects/
├── docs/
│   └── index.html          ← GitHub Pages will serve this
├── ExpenseTracker/          ← Spring Boot code (kept for reference)
└── README.md
```

### Step 2: Enable GitHub Pages

1. Go to your repository on GitHub: https://github.com/Lokeshh18/Projects
2. Click **Settings** tab
3. Click **Pages** in the left sidebar
4. Under **Source**, select:
   - Branch: `main` (or `master`)
   - Folder: `/docs`
5. Click **Save**

### Step 3: Access Your Site

After 1-2 minutes, your site will be live at:
```
https://lokeshh18.github.io/Projects/
```

Or if your repository name is different:
```
https://<your-username>.github.io/<repository-name>/
```

### Step 4: Update GitHub Pages

Every time you update `docs/index.html`:
1. Commit and push changes:
   ```bash
   git add docs/index.html
   git commit -m "Update frontend"
   git push
   ```
2. GitHub Pages will automatically update in 1-2 minutes

---

## Option 2: Deploy Full Stack to Render/Railway

### Deploy to Render.com (Free)

1. **Create a new Web Service** on https://render.com
2. **Connect your GitHub repository**
3. **Configure:**
   - **Build Command:** `cd ExpenseTracker && mvn clean package -DskipTests`
   - **Start Command:** `cd ExpenseTracker && java -jar target/expense-tracker-1.0.0.jar`
   - **Environment Variables:**
     ```
     DATABASE_URL=mysql://user:pass@host:port/expense_tracker_db
     SPRING_DATASOURCE_URL=${DATABASE_URL}
     SPRING_DATASOURCE_USERNAME=user
     SPRING_DATASOURCE_PASSWORD=pass
     ```
4. **Add MySQL database** (Render has managed MySQL/PostgreSQL)
5. **Deploy!**

### Deploy to Railway.app (Free)

1. **Create new Project** on https://railway.app
2. **Deploy from GitHub**
3. **Add MySQL plugin** from Railway marketplace
4. **Set environment variables:**
   ```
   SPRING_DATASOURCE_URL=${{MYSQLURL}}
   SPRING_DATASOURCE_USERNAME=${{MYSQLUSER}}
   SPRING_DATASOURCE_PASSWORD=${{MYSQLPASSWORD}}
   ```
5. **Deploy!**

---

## 📋 Checklist Before Deploying

### For GitHub Pages:
- [ ] `docs/index.html` exists and is up to date
- [ ] Repository is public (or GitHub Pages is enabled for private)
- [ ] GitHub Pages source is set to `/docs` folder
- [ ] No backend API calls in `docs/index.html` (uses localStorage)

### For Full Stack:
- [ ] `application.properties` uses environment variables
- [ ] Database is configured and accessible
- [ ] `pom.xml` has correct build configuration
- [ ] Port is configurable (defaults to 8080)

---

## 🔗 Custom Domain (Optional)

### For GitHub Pages:

1. Buy a domain (e.g., from Namecheap, GoDaddy)
2. In your repository Settings → Pages → Custom domain
3. Enter your domain: `expenseiq.com`
4. Add CNAME record in your DNS settings:
   ```
   CNAME  lokeshh18.github.io
   ```
5. Wait for DNS propagation (up to 48 hours)

### For Render/Railway:

1. Go to your service settings
2. Add custom domain
3. Update DNS records as instructed
4. SSL certificate is auto-provisioned

---

## 🎯 Quick Commands

### Push to GitHub
```bash
git add .
git commit -m "Update ExpenseIQ"
git push origin main
```

### Check GitHub Pages Status
Visit: `https://github.com/Lokeshh18/Projects/deployments`

### Test Locally
```bash
# Test GitHub Pages version locally
cd docs
python -m http.server 8000
# Open http://localhost:8000
```

---

## ⚡ Troubleshooting

### GitHub Pages not updating
- Clear browser cache (Ctrl + Shift + R)
- Check GitHub Actions for build errors
- Verify `/docs` folder is selected as source

### 404 Error on GitHub Pages
- Ensure `index.html` is in `/docs` folder
- Check repository is public
- Wait 1-2 minutes after pushing

### API Calls Failing on GitHub Pages
- GitHub Pages is static only (no backend)
- Use localStorage version (already implemented in `docs/index.html`)
- For full backend, deploy to Render/Railway

---

## 📊 Current Deployment Status

| Component | Status | URL |
|-----------|--------|-----|
| Frontend Demo | ✅ Ready | https://lokeshh18.github.io/Projects/ |
| Spring Boot API | 📦 Local Only | http://localhost:8080 |
| Full Stack | 🔄 To Deploy | Render/Railway |

---

**Your GitHub Pages site is ready to go! 🚀**

Just enable GitHub Pages in your repository settings and it will be live at:
**https://lokeshh18.github.io/Projects/**
