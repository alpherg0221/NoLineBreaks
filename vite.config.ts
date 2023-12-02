import {defineConfig} from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  base: "/NoLineBreaks/",
  build: {
    rollupOptions: {
      output: {
        assetFileNames: `assets/[name].[ext]`,
        entryFileNames: `assets/[name].js`,
      }
    }
  }
})
