import {create} from "zustand";
import {format} from "../utils/formatter.ts";

type UpdatableAppState = {
  text?: string;
  translater?: string;
}

type AppViewModelType = {
  text: string;
  formattedText: string;
  translater: string;
  update: (newState: UpdatableAppState) => void;
  copy: () => void;
  open: () => void;
}

export const appViewModel = create<AppViewModelType>((set, get) => ({
  text: "",
  formattedText: "",
  translater: "DeepL",
  update: (newState) => set((current) => ({
    text: newState.text ?? current.text,
    formattedText: format(newState.text) ?? current.formattedText,
    translater: newState.translater ?? current.translater,
  })),
  copy: () => navigator.clipboard.writeText(get().formattedText),
  open: () => {
    if (get().translater == "DeepL") {
      window.open(`https://www.deepl.com/ja/translator#en/ja/${get().formattedText}`, "_blank")
    } else if (get().translater == "Google") {
      window.open(`https://translate.google.co.jp/?sl=en&tl=ja&text=${get().formattedText}`, "_blank")
    }
  }
}))