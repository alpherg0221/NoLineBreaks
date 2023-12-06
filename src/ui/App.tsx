import './App.css'
import {appViewModel} from './AppState.tsx'
import {StackShim} from "@fluentui/react-migration-v8-v9";
import {
  Button,
  CompoundButton,
  Divider,
  Dropdown,
  Field,
  Option,
  Textarea,
  Toast,
  Toaster,
  ToastTitle,
  useId,
  useToastController
} from "@fluentui/react-components";
import {CopyRegular, DismissRegular, OpenRegular} from "@fluentui/react-icons";

function App() {
  const viewModel = appViewModel()

  const textHeight: string = "75vh";
  const textWidth: string = "47.5vw";

  const toasterId = useId("toaster");
  const {dispatchToast} = useToastController(toasterId);

  const copy = () => {
    viewModel.copy();
    dispatchToast(<Toast><ToastTitle>Copied Formatted Text</ToastTitle></Toast>, {intent: "success"});
  };

  return (
    <div style={{minHeight: "100vh", display: "grid", placeItems: "center", textAlign: "center"}}>
      <Toaster toasterId={toasterId}/>
      <StackShim tokens={{childrenGap: 40}} horizontalAlign="center" verticalAlign="center">
        <Button icon={<DismissRegular fontSize={48}/>} onClick={() => viewModel.update({text: ""})}/>

        <StackShim horizontal tokens={{childrenGap: 20}}>
          <Field
            style={{height: textHeight, width: textWidth, maxHeight: textHeight}}
            validationState={viewModel.text.length <= 5000 ? "success" : "error"}
            validationMessage={`${viewModel.text.length} / 5000`}
          >
            <Textarea
              value={viewModel.text}
              style={{height: textHeight, width: textWidth}}
              textarea={{style: {maxHeight: textHeight}}}
              size="large"
              onChange={(_, data) => {
                viewModel.update({text: data.value})
              }}
            />
          </Field>

          <Field
            style={{height: textHeight, width: textWidth}}
            validationState={viewModel.formattedText.length <= 5000 ? "success" : "error"}
            validationMessage={`${viewModel.formattedText.length} / 5000`}
          >
            <Textarea
              value={viewModel.formattedText}
              style={{height: textHeight, width: textWidth}}
              textarea={{style: {maxHeight: textHeight}}}
              size="large"
              readOnly
            />
          </Field>
        </StackShim>

        <Divider/>

        <StackShim horizontal verticalAlign="center" tokens={{childrenGap: 20}}>
          <CompoundButton
            style={{width: "37.5vw", fontSize: 24}}
            icon={<CopyRegular fontSize={48}/>}
            appearance="subtle"
            onClick={copy}
          >
            Copy Formatted Text
          </CompoundButton>

          <Dropdown
            style={{width: "20vw", height: 40}}
            appearance="outline"
            size="large"
            defaultValue={viewModel.translater}
            value={viewModel.translater}
            onOptionSelect={(_, data) => {
              viewModel.update({translater: data.optionValue})
            }}
          >
            <Option>DeepL</Option>
            <Option>Google</Option>
          </Dropdown>

          <CompoundButton
            style={{width: "37.5vw", fontSize: 24}}
            icon={<OpenRegular fontSize={48}/>}
            appearance="subtle"
            onClick={viewModel.open}
          >
            Open in New Tab
          </CompoundButton>
        </StackShim>
      </StackShim>
    </div>
  )
}

export default App
