import {defineConfig} from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  build: {
    rollupOptions: {
      output: {
        assetFileNames: `src/assets/[name].[ext]`,
        entryFileNames: `src/assets/[name].js`,
      }
    }
  }
})
