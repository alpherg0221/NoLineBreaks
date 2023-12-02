export const format = (text: string | undefined) => {
  if (text === undefined) {
    return undefined;
  } else {
    return text.replaceAll('. ', '.\n')
      .replaceAll('\n', '\n\n')
      .replaceAll('i.e.\n\n', 'i.e. ')
      .replaceAll('e.g.\n\n', 'e.g. ')
      .replaceAll('Fig.\n\n', 'Fig. ')
      .replaceAll('Tab.\n\n', 'Tab. ')
      .replaceAll('et al.\n\n', 'et al. ')
      .replaceAll('et.\n\nal.\n\n', 'et. al. ')
      .replaceAll(' vs.\n\n', ' vs. ')
      .replaceAll('rf.\n\n', 'rf. ')
      .replaceAll('/', '%5C%2F');
  }
}